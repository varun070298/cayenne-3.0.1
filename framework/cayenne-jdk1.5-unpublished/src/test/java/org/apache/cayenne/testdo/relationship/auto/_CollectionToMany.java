package org.apache.cayenne.testdo.relationship.auto;

/** Class _CollectionToMany was generated by Cayenne.
  * It is probably a good idea to avoid changing this class manually, 
  * since it may be overwritten next time code is regenerated. 
  * If you need to make any customizations, please use subclass. 
  */
public class _CollectionToMany extends org.apache.cayenne.CayenneDataObject {

    public static final String TARGETS_PROPERTY = "targets";

    public static final String ID_PK_COLUMN = "ID";

    public void addToTargets(org.apache.cayenne.testdo.relationship.CollectionToManyTarget obj) {
        addToManyTarget("targets", obj, true);
    }
    public void removeFromTargets(org.apache.cayenne.testdo.relationship.CollectionToManyTarget obj) {
        removeToManyTarget("targets", obj, true);
    }
    public java.util.Collection getTargets() {
        return (java.util.Collection)readProperty("targets");
    }
    
    
}