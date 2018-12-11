package com.softwarelma.ewd.bean;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.naming.InitialContext;

import com.softwarelma.ewd.ejb.EwdEjb;
import com.softwarelma.ewd.ejb.EwdEjbInterface;

@ManagedBean(name = "editorBean")
public class EwdMainBean {

    private transient Logger logger = Logger.getLogger(EwdMainBean.class.getName());
    private EwdEjbInterface ewdEjb;
    private String value = "from bean";

    public EwdMainBean() {
        this.init();
    }

    /**
     * app-name = the name of the .ear (without the .ear suffix) or the application name configured via application.xml
     * deployment descriptor. If the application isn't packaged in a .ear then there will be no app-name part to the
     * JNDI string.
     * 
     * module-name = the name of the .jar or .war (without the .jar/.war suffix) in which the bean is deployed or the
     * module-name configured in web.xml/ejb-jar.xml of the deployment. The module name is mandatory part in the JNDI
     * string.
     */
    private void init() {
        try {
            InitialContext ctx = new InitialContext();
            // this.ewdEjb = (EwdEjb) ctx.lookup("java:global/ewd/EwdEjb!com.softwarelma.ewd.ejb.EwdEjb");
            // this.ewdEjb = (EwdEjb) ctx.lookup("java:app/ewd/EwdEjb!com.softwarelma.ewd.ejb.EwdEjb");
            this.ewdEjb = (EwdEjb) ctx.lookup("java:module/EwdEjb!com.softwarelma.ewd.ejb.EwdEjb");

            // String appName = "";// + "/";
            // String moduleName = "ewd2" + "/";
            // String distinctName = "";// + "/";
            // String beanName = "EwdEjb" + "/";
            // String viewClassName = EwdEjbInterface.class.getName();

            // this.ewdEjb = (EwdEjbInterface) ctx
            // .lookup("ejb:" + appName + moduleName + distinctName + beanName + "!" + viewClassName);

            // test
            this.ewdEjb.getText();
        } catch (Exception e) {
            this.logger.log(Level.SEVERE, "\tinit. Message: " + e.getMessage(), e);
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
