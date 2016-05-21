package com.bsx.vtca.biensoxe.Data;

/**
 * Created by danhhoang on 15/01/2016.
 */
public class DistrictItem {
    public String Id;
    public String Title;
    public String TitleSearch;
    public String Html;

    public DistrictItem(String id, String title,String titleSearch, String html) {
        this.Id = id;
        this.Title = title;
        this.TitleSearch = titleSearch;
        this.Html = html;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getHtml() {
        return Html;
    }

    public void setHtml(String html) {
        Html = html;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTitleSearch() {
        return TitleSearch;
    }

    public void setTitleSearch(String titleSearch) {
        TitleSearch = titleSearch;
    }

}
