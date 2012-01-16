package jsf;

import jpa.entities.Opcion;
import jsf.util.JsfUtil;
import jsf.util.PaginationHelper;
import jpa.session.OpcionFacade;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import org.primefaces.event.RowEditEvent;

@ManagedBean(name = "opcionController")
@SessionScoped
public class OpcionController implements Serializable {

    private Opcion current;
    private DataModel items = null;
    @EJB
    private jpa.session.OpcionFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private List<Opcion> lstOpciones=null;

    public List<Opcion> getLstOpciones() {
        return lstOpciones;
    }
    public void rowEditListener(RowEditEvent event){  
         Opcion opcion=(Opcion) event.getObject();  
// Realizaremos las operaciones que correspondan  
        Opcion opcionToUpdate= ejbFacade.find(opcion.getOpcionPK());
        opcionToUpdate.setOpcNombre(opcion.getOpcNombre());
        opcionToUpdate.setOpcRuta(opcion.getOpcRuta());
        ejbFacade.edit(opcionToUpdate);
        
} 
    public OpcionController() {
    }
    public void fillOpciones() throws ParseException{
            try{
            lstOpciones = ejbFacade.findAll();
             
            }catch(Exception ex){
             
            }
            
        }
    public Opcion getSelected() {
        if (current == null) {
            current = new Opcion();
            current.setOpcionPK(new jpa.entities.OpcionPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private OpcionFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Opcion) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Opcion();
        current.setOpcionPK(new jpa.entities.OpcionPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("OpcionCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Opcion) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("OpcionUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Opcion) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("OpcionDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    @FacesConverter(forClass = Opcion.class)
    public static class OpcionControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            OpcionController controller = (OpcionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "opcionController");
            return controller.ejbFacade.find(getKey(value));
        }

        jpa.entities.OpcionPK getKey(String value) {
            jpa.entities.OpcionPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new jpa.entities.OpcionPK();
            key.setOpcCodigo(values[0]);
            key.setFunCodigo(values[1]);
            return key;
        }

        String getStringKey(jpa.entities.OpcionPK value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value.getOpcCodigo());
            sb.append(SEPARATOR);
            sb.append(value.getFunCodigo());
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Opcion) {
                Opcion o = (Opcion) object;
                return getStringKey(o.getOpcionPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + OpcionController.class.getName());
            }
        }
        
    }
}
