package myPackage.ui;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Button extends SimpleTagSupport {
    private String id;
    private String text;
    private boolean outlined;
    private boolean rounded;
    private String name;
    private String onclick;

    
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
            
            String buttonStyle = "";
        
            if(outlined){
                buttonStyle = "border: 1px solid #141718; color: #141718; background-color: #fff;";
            }else {
                buttonStyle = "background-color: #141718; color: #fff;";
            }

            if (rounded) {
                buttonStyle += " border-radius: 80px;";
            }else {
                buttonStyle += " border-radius: 8px;";
            }

            out.println(String.format("<button class=\"button\" id=\""+ id +"\" style=\"" + buttonStyle + "\" onclick="+ onclick +">%s</button>", text));


        } catch (java.io.IOException ex) {
            throw new JspException("Error in Button tag", ex);
        }
    }
    
    public void setId(String id){
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOutlined(boolean outlined) {
        this.outlined = outlined;
    }

    public void setRounded(boolean rounded) {
        this.rounded = rounded;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public void setOnclick(String onclick){
        this.onclick = onclick;
    }
    
}
