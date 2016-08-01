package worldgo.rxoperator.model;

import java.util.List;

import worldgo.rxoperator.utils.Event;

/**
 * @author ricky.yao on 2016/7/28.
 */
public class Catalog extends BaseModel {


    public List<SubCatalog> subCatalog;

    public Catalog(String title, List<SubCatalog> subCatalog) {
        this.title = title;
        this.subCatalog = subCatalog;
    }

    public static class SubCatalog extends BaseModel {
        public Event event;

        public SubCatalog(String title, Event event) {
            this.title = title;
            this.event = event;
        }
    }
}
