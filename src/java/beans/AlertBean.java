package beans;

//@author HS19011-Edwin Alexander Hernandez Sanchez

import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;


@ManagedBean(name = "alertBean")
public class AlertBean {
    static String cod = "const Toast = Swal.mixin({\n" +
                        "   toast: true,\n" +
                        "   position: 'bottom-end',\n" +
                        "   showConfirmButton: false,\n" +
                        "   timer: 3000,\n" +
                        "   timerProgressBar: true,\n" +
                        "   didOpen: (toast) => {\n" +
                        "       toast.addEventListener('mouseenter', Swal.stopTimer)\n" +
                        "       toast.addEventListener('mouseleave', Swal.resumeTimer)\n" +
                        "   }\n" +
                        "})\n" +
                        "\n" +
                        "Toast.fire({\n" +
                        "   icon: 'success',\n" +
                        "   title: 'Se ha guardado el archivo'\n" +
                        "})";
    
    public void submit(){
        RequestContext contexto = RequestContext.getCurrentInstance();
        contexto.execute(cod);
    }
}


