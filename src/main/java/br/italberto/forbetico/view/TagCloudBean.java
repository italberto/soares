/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.view;

import br.italberto.forbetico.persistence.facade.FacadeKeyword;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.tagcloud.DefaultTagCloudItem;
import org.primefaces.model.tagcloud.DefaultTagCloudModel;
import org.primefaces.model.tagcloud.TagCloudItem;
import org.primefaces.model.tagcloud.TagCloudModel;

@ManagedBean
public class TagCloudBean {

    private TagCloudModel model;

    @PostConstruct
    public void init() {
        //public TagCloudBean() {
        model = new DefaultTagCloudModel();

        FacadeKeyword fk = new FacadeKeyword();
        HashMap<String, BigInteger> keywords = fk.getCount();

        Iterator itr = keywords.keySet().iterator();
        while (itr.hasNext()) {
            String key = (String) itr.next();
            BigInteger value = keywords.get(key);

            model.addTag(new DefaultTagCloudItem(key, value.intValue()));
        }

        fk.closeSession();
    }

    public TagCloudModel getModel() {
        return model;
    }

    public void onSelect(SelectEvent event) {
        TagCloudItem item = (TagCloudItem) event.getObject();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", item.getLabel());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
