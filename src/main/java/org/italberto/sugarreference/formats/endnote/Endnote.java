/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.italberto.sugarreference.formats.endnote;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author italberto
 */
@XmlRootElement(name = "RECORD")
public class Endnote {
    private String referenceType;
    private String refNum;
    private List<String> authors;
    private String year;
    private String title;
    private List<String> secondaryAuthors;
    private String secondaryTitle;
    private String placePublished;
    private String publisher;
    private String volume;
    private String numberOfVolumes;
    private String number;
    private String pages;
    private String section;
    private List<String> tertiaryAuthors;
    private String tertiaryTitle;
    private String edition;
    private String date;
    private String typeOfWork;
    private List<String> subsidaryAuthors;
    private String shortTitle;
    private String alternativeTitle;
    private String isbn;
    private String originalPub;
    private String reprintEdition;
    private String reviwedItem;
    private String custom1;
    private String custom2;
    private String custom3;
    private String custom4;
    private String custom5;
    private String custom6;
    private String accessionNumber;
    private String callNumber;
    private String label;
    private List<String> keywords;
    private String textAbstract;
    private String notes;
    private String url;
    private String authorAddress;
    private String caption;

    public Endnote() {
    }

    @XmlElement(name = "REFERENCE_TYPE")
    public String getReferenceType() {
        return referenceType;
    }

    @XmlElement(name = "REFNUM")
    public String getRefNum() {
        return refNum;
    }

    @XmlElementWrapper(name = "AUTHORS")
    @XmlElement(name = "AUTHOR")
    public List<String> getAuthors() {
        return authors;
    }

    @XmlElement(name = "YEAR")
    public String getYear() {
        return year;
    }

    @XmlElement(name = "TITLE")
    public String getTitle() {
        return title;
    }

    @XmlElementWrapper(name = "SECONDARY_AUTHORS")
    @XmlElement(name = "SECONDARY_AUTHOR")
    public List<String> getSecondaryAuthors() {
        return secondaryAuthors;
    }

    @XmlElement(name = "SECONDARY_TITLE")
    public String getSecondaryTitle() {
        return secondaryTitle;
    }

    @XmlElement(name = "PLACE_PUBLISHED")
    public String getPlacePublished() {
        return placePublished;
    }

    @XmlElement(name = "PUBLISHER")
    public String getPublisher() {
        return publisher;
    }

    @XmlElement(name = "VOLUME")
    public String getVolume() {
        return volume;
    }

    @XmlElement(name = "NUMBER_OF_VOLUMES")
    public String getNumberOfVolumes() {
        return numberOfVolumes;
    }

    @XmlElement(name = "NUMBER")
    public String getNumber() {
        return number;
    }

    @XmlElement(name = "PAGES")
    public String getPages() {
        return pages;
    }

    
    @XmlElement(name = "SECTION")
    public String getSection() {
        return section;
    }

    @XmlElementWrapper(name = "TERTIARY_AUTHORS")
    @XmlElement(name = "TERTIARY_AUTHOR")
    public List<String> getTertiaryAuthors() {
        return tertiaryAuthors;
    }

    @XmlElement(name = "TERTIARY_TITLE")
    public String getTertiaryTitle() {
        return tertiaryTitle;
    }

    @XmlElement(name = "EDITION")
    public String getEdition() {
        return edition;
    }

    @XmlElement(name = "DATE")
    public String getDate() {
        return date;
    }

    @XmlElement(name = "TYPE_OF_WORK")
    public String getTypeOfWork() {
        return typeOfWork;
    }

    @XmlElementWrapper(name = "SYBSIDIARY_AUTHORS")
    @XmlElement(name = "SYBSIDIARY_AUTHOR")
    public List<String> getSubsidaryAuthors() {
        return subsidaryAuthors;
    }

    @XmlElement(name = "SHORT_TITLE")
    public String getShortTitle() {
        return shortTitle;
    }

    
    @XmlElement(name = "ALTERNATIVE_TITLE")
    public String getAlternativeTitle() {
        return alternativeTitle;
    }

    @XmlElement(name = "ISBN")
    public String getIsbn() {
        return isbn;
    }

    @XmlElement(name = "ORIGINAL_PUB")
    public String getOriginalPub() {
        return originalPub;
    }

    @XmlElement(name = "REPRINT_EDITION")
    public String getReprintEdition() {
        return reprintEdition;
    }

    @XmlElement(name = "REVIWED_ITEM")
    public String getReviwedItem() {
        return reviwedItem;
    }

    @XmlElement(name = "CUSTOM1")
    public String getCustom1() {
        return custom1;
    }

    @XmlElement(name = "CUSTOM2")
    public String getCustom2() {
        return custom2;
    }

    @XmlElement(name = "CUSTOM3")
    public String getCustom3() {
        return custom3;
    }

    @XmlElement(name = "CUSTOM4")
    public String getCustom4() {
        return custom4;
    }

    @XmlElement(name = "CUSTOM5")
    public String getCustom5() {
        return custom5;
    }

    @XmlElement(name = "CUSTOM6")
    public String getCustom6() {
        return custom6;
    }

    @XmlElement(name = "ACCESSION_NUMBER")
    public String getAccessionNumber() {
        return accessionNumber;
    }

    @XmlElement(name = "CALL_NUMBER")
    public String getCallNumber() {
        return callNumber;
    }

    @XmlElement(name = "LABEL")
    public String getLabel() {
        return label;
    }

    @XmlElementWrapper(name = "KEYWORDS")
    @XmlElement(name = "KEYWORD")
    public List<String> getKeywords() {
        return keywords;
    }

    @XmlElement(name = "ABSTRACT")
    public String getTextAbstract() {
        return textAbstract;
    }

    @XmlElement(name = "NOTES")
    public String getNotes() {
        return notes;
    }

    @XmlElement(name = "URL")
    public String getUrl() {
        return url;
    }

    @XmlElement(name = "AUTHOR_ADDRESS")
    public String getAuthorAddress() {
        return authorAddress;
    }

    @XmlElement(name = "CAPTION")
    public String getCaption() {
        return caption;
    }

    
    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    public void setRefNum(String refNum) {
        this.refNum = refNum;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSecondaryAuthors(List<String> secondaryAuthors) {
        this.secondaryAuthors = secondaryAuthors;
    }

    public void setSecondaryTitle(String secondaryTitle) {
        this.secondaryTitle = secondaryTitle;
    }

    public void setPlacePublished(String placePublished) {
        this.placePublished = placePublished;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setNumberOfVolumes(String numberOfVolumes) {
        this.numberOfVolumes = numberOfVolumes;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setTertiaryAuthors(List<String> tertiaryAuthors) {
        this.tertiaryAuthors = tertiaryAuthors;
    }

    public void setTertiaryTitle(String tertiaryTitle) {
        this.tertiaryTitle = tertiaryTitle;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTypeOfWork(String typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    public void setSubsidaryAuthors(List<String> subsidaryAuthors) {
        this.subsidaryAuthors = subsidaryAuthors;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public void setAlternativeTitle(String alternativeTitle) {
        this.alternativeTitle = alternativeTitle;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setOriginalPub(String originalPub) {
        this.originalPub = originalPub;
    }

    public void setReprintEdition(String reprintEdition) {
        this.reprintEdition = reprintEdition;
    }

    public void setReviwedItem(String reviwedItem) {
        this.reviwedItem = reviwedItem;
    }

    public void setCustom1(String custom1) {
        this.custom1 = custom1;
    }

    public void setCustom2(String custom2) {
        this.custom2 = custom2;
    }

    public void setCustom3(String custom3) {
        this.custom3 = custom3;
    }

    public void setCustom4(String custom4) {
        this.custom4 = custom4;
    }

    public void setCustom5(String custom5) {
        this.custom5 = custom5;
    }

    public void setCustom6(String custom6) {
        this.custom6 = custom6;
    }

    public void setAccessionNumber(String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public void setTextAbstract(String textAbstract) {
        this.textAbstract = textAbstract;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setAuthorAddress(String authorAddress) {
        this.authorAddress = authorAddress;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
    
    
    
    
}
