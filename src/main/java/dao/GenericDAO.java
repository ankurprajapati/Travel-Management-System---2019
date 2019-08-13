/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import alexevan.annotations.MapToColumn;
import alexevan.annotations.MapToTable;
import alexevan.annotations.PrimaryKey;
import java.lang.annotation.Annotation;
//import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alex Christian
 */
public final class GenericDAO {

    public static class Condition {

        protected String columnName;
        protected int condition;
        protected Object value;

        private Condition(String columnName, int condition, Object value) {
            this.columnName = columnName;
            this.condition = condition;
            this.value = value;
        }

        protected Map<String, Object> getCondition() {
            Map<String, Object> conditions = new HashMap<>();
            switch (this.condition) {
                case 1:
                    conditions.put("( " + columnName + " = ? )", value);
                    break;
                case 2:
                    conditions.put("( " + columnName + " != ? )", value);
                    break;
                case 3:
                    conditions.put("( " + columnName + " >= ? )", value);
                    break;
                case 4:
                    conditions.put("( " + columnName + " <= ? )", value);
                    break;
                case 5:
                    conditions.put("( " + columnName + " > ? )", value);
                    break;
                case 6:
                    conditions.put("( " + columnName + " < ? )", value);
                    break;
            }
            return conditions;
        }

        private Condition getOtherCondition() {
            return this;
        }

    }

    public static final class ORCondition extends Condition {

        private Condition otherCondition;

        public ORCondition(Condition c1, Condition c2) {
            super(c1.columnName, c1.condition, c1.value);
            otherCondition = c2;
        }

        @Override
        protected Map<String, Object> getCondition() {
            Map<String, Object> conditions = new HashMap<>();
            switch (this.condition) {
                case 1:
                    conditions.put("( " + this.columnName + " = ? )", this.value);
                    break;
                case 2:
                    conditions.put("( " + this.columnName + " != ? )", this.value);
                    break;
                case 3:
                    conditions.put("( " + this.columnName + " >= ? )", this.value);
                    break;
                case 4:
                    conditions.put("( " + this.columnName + " <= ? )", this.value);
                    break;
                case 5:
                    conditions.put("( " + this.columnName + " > ? )", this.value);
                    break;
                case 6:
                    conditions.put("( " + this.columnName + " < ? )", this.value);
                    break;
            }
            switch (otherCondition.condition) {
                case 1:
                    conditions.put("( " + otherCondition.columnName + "  = ? )", otherCondition.value);
                    break;
                case 2:
                    conditions.put("( " + otherCondition.columnName + "  != ? )", otherCondition.value);
                    break;
                case 3:
                    conditions.put("( " + otherCondition.columnName + "  >= ? )", otherCondition.value);
                    break;
                case 4:
                    conditions.put("( " + otherCondition.columnName + "  <= ? )", otherCondition.value);
                    break;
                case 5:
                    conditions.put("( " + otherCondition.columnName + "  > ? )", otherCondition.value);
                    break;
                case 6:
                    conditions.put("( " + otherCondition.columnName + "  < ? )", otherCondition.value);
                    break;
            }
            return conditions;
        }

        public Condition getOtherCondition() {
            return otherCondition;
        }

    }

    public static final class ANDCondition extends Condition {

        private Condition otherCondition;

        public ANDCondition(Condition c1, Condition c2) {
            super(c1.columnName, c1.condition, c1.value);
            otherCondition = c2;
        }

        @Override
        protected Map<String, Object> getCondition() {
            Map<String, Object> conditions = new HashMap<>();
            switch (this.condition) {
                case 1:
                    conditions.put("( " + this.columnName + " = ? )", this.value);
                    break;
                case 2:
                    conditions.put("( " + this.columnName + " != ? )", this.value);
                    break;
                case 3:
                    conditions.put("( " + this.columnName + " >= ? )", this.value);
                    break;
                case 4:
                    conditions.put("( " + this.columnName + " <= ? )", this.value);
                    break;
                case 5:
                    conditions.put("( " + this.columnName + " > ? )", this.value);
                    break;
                case 6:
                    conditions.put("( " + this.columnName + " < ? )", this.value);
                    break;
            }
            switch (otherCondition.condition) {
                case 1:
                    conditions.put("( " + otherCondition.columnName + "  = ? )", otherCondition.value);
                    break;
                case 2:
                    conditions.put("( " + otherCondition.columnName + "  != ? )", otherCondition.value);
                    break;
                case 3:
                    conditions.put("( " + otherCondition.columnName + "  >= ? )", otherCondition.value);
                    break;
                case 4:
                    conditions.put("( " + otherCondition.columnName + "  <= ? )", otherCondition.value);
                    break;
                case 5:
                    conditions.put("( " + otherCondition.columnName + "  > ? )", otherCondition.value);
                    break;
                case 6:
                    conditions.put("( " + otherCondition.columnName + "  < ? )", otherCondition.value);
                    break;
            }
            return conditions;
        }

        public Condition getOtherCondition() {
            return otherCondition;
        }

    }
    private static List<Class> classes = new ArrayList<>();
    private static Map<Class, Map<String, Field>> allMappings = new HashMap<>();

    public static final int EQUALS = 1;
    public static final int NOT_EQUALS = 2;
    public static final int GREATER_THAN_EQUALS = 3;
    public static final int LESS_THAN_EQUALS = 4;
    public static final int LESS_THAN = 5;
    public static final int GREATER_THAN = 6;

    public final static Condition makeCondition(String columnName, int condition, Object value) {
        return new Condition(columnName, condition, value);
    }

    public static Condition makeORCondition(Condition c1, Condition c2) {
        return new ORCondition(c1, c2);
    }

    public static Condition makeANDCondition(Condition c1, Condition c2) {
        return new ANDCondition(c1, c2);
    }

    public final static void addAnnotatedClass(Class clazz) {
        classes.add(clazz);
    }

    public final static void addAnnotatedClasses(List<Class> clazzes) {
        classes = clazzes;
    }

    public final static void generateMappings() {
        for (Class cls : classes) {
            Map<String, Field> mapping = new HashMap<String, Field>();
            for (java.lang.reflect.Field field : cls.getDeclaredFields()) {
                MapToColumn clmn = null;
                Field thisField = null;
                PrimaryKey pk;
                try {
                    clmn = (MapToColumn) field.getDeclaredAnnotations()[0];
                    thisField = new Field(field, false);
                } catch (ClassCastException ex) {
                    thisField = new Field(field, true);
                    clmn = (MapToColumn) field.getDeclaredAnnotations()[1];
                } finally {
                    mapping.put(clmn.value(), thisField);
                }
            }
            allMappings.put(cls, mapping);
        }
    }

    private GenericDAO() {

    }

    private final static int add(Class cls, Object t) {
        try {
            MapToTable anno = (MapToTable) cls.getAnnotations()[0];
            System.out.println(anno.value());

            Map<String, Field> mapping = allMappings.get(cls);

            String query = "INSERT INTO " + anno.value() + " ";
            String colnames = "", qm = "";
            for (String key : mapping.keySet()) {
                colnames += key + ",";
                mapping.get(key).getField().setAccessible(true);
                System.out.println(mapping.get(key).getField().get(t));
                qm += "?,";
            }
            colnames = colnames.substring(0, colnames.length() - 1);
            qm = qm.substring(0, qm.length() - 1);
            query += "(" + colnames + ") VALUES " + "(" + qm + ")";
            PreparedStatement ps = Database.getConnection().prepareStatement(query);

            int i = 1;
            for (String key : mapping.keySet()) {
                ps.setObject(i, mapping.get(key).getField().get(t));
                i++;
            }

            if (commons.Common.SHOW_SQL) {
                System.out.println(query);
            }
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new Exception();
            }

            return rows;
        } catch (Exception sqlex) {
            sqlex.printStackTrace();
            return 0;
        }
    }

    private final static int update(Class cls, Object t) {
        try {
            Map<String, Field> mapping = allMappings.get(cls);
            MapToTable anno = (MapToTable) cls.getAnnotations()[0];
            String query = "UPDATE " + anno.value() + " SET ";
            String primaryKey = "";
            String updations = "";
            for (String key : mapping.keySet()) {
                updations += key + "=?,";
                mapping.get(key).getField().setAccessible(true);
                System.out.println(mapping.get(key).getField().get(t));
                if (mapping.get(key).isPrimaryKey()) {
                    primaryKey = ((PrimaryKey) mapping.get(key).getField().getDeclaredAnnotations()[0]).value();
                }
            }
            updations = updations.substring(0, updations.length() - 1);

            query += updations;
            query += " WHERE " + primaryKey + "=?";

            PreparedStatement psmt = Database.getConnection().prepareStatement(query);
            int i = 1;
            Field primaryField = null;
            for (String key : mapping.keySet()) {
                if (key.equals(primaryKey)) {
                    primaryField = mapping.get(key);
                }
                psmt.setObject(i, mapping.get(key).getField().get(t));
                i++;
            }
            psmt.setObject(i, primaryField.getField().get(t));
            int rows = psmt.executeUpdate();
            if (rows == 0) {
                throw new Exception();
            }
            if (commons.Common.SHOW_SQL) {
                System.out.println(query);
            }
            return rows;
        } catch (Exception sqlex) {
            //sqlex.printStackTrace();
            return 0;
        }
    }

    public final static int save(Class clazz, Object t) {
        int rows = 0;
        try {
            rows = update(clazz, t);
            if (rows == 0) {
                throw new Exception();
            }
        } catch (Exception ex) {
            try {
                rows = add(clazz, t);
            } catch (Exception ex1) {
                ex1.printStackTrace();
                rows = 0;
            }
        }
        return rows;
    }

    public final static int delete(Class cls, Object t) {
        try {
            Map<String, Field> mapping = allMappings.get(cls);
            String query = "DELETE FROM " + ((MapToTable) cls.getDeclaredAnnotations()[0]).value() + " WHERE ";
            String primaryKey = "";
            java.lang.reflect.Field field = null;
            for (String key : mapping.keySet()) {
                if (mapping.get(key).isPrimaryKey()) {
                    primaryKey = ((PrimaryKey) mapping.get(key).getField().getDeclaredAnnotations()[0]).value();
                    field = mapping.get(key).getField();
                }
            }
            query += primaryKey + "= ?";
            PreparedStatement psmt = Database.getConnection().prepareStatement(query);
            field.setAccessible(true);
            psmt.setObject(1, field.get(t));
            int rows = psmt.executeUpdate();

            if (commons.Common.SHOW_SQL) {
                System.out.println(query);
            }
            return rows;
        } catch (Exception ex) {
            //System.out.println(ex.);
            ex.printStackTrace();
            return 0;
        }
    }

    public final static List<Object> objects(Class clazz, String customWhereQuery) throws Exception {
        List<Object> objects = new ArrayList<>();
        Map<String, Field> mapping = allMappings.get(clazz);
        String query = "SELECT * FROM " + ((MapToTable) clazz.getDeclaredAnnotations()[0]).value() + " WHERE " + customWhereQuery;
        System.out.println(query);
        Statement psmt = Database.getConnection().createStatement();
        ResultSet rs = psmt.executeQuery(query);
        while (rs.next()) {
            Object o = Class.forName(clazz.getName()).newInstance();
            for (String key : mapping.keySet()) {
                java.lang.reflect.Field field = mapping.get(key).getField();
                field.setAccessible(true);
                field.set(o, rs.getObject(key));
            }
            objects.add(o);
        }
        return objects;
    }

    public final static List<Object> objects(Class clazz, String preparedWhereQuery, List<Object> vals) throws Exception {
        List<Object> objects = new ArrayList<>();
        Map<String, Field> mapping = allMappings.get(clazz);
        String query = "SELECT * FROM " + ((MapToTable) clazz.getDeclaredAnnotations()[0]).value() + " WHERE ";
        query += preparedWhereQuery;
        System.out.println(query);
        PreparedStatement psmt = Database.getConnection().prepareStatement(query);
        int i = 1;
        for (Object obj : vals) {
            psmt.setObject(i, obj);
            i++;
        }
        ResultSet rs = psmt.executeQuery();
        while (rs.next()) {
            Object o = Class.forName(clazz.getName()).newInstance();
            for (String key : mapping.keySet()) {
                java.lang.reflect.Field field = mapping.get(key).getField();
                field.setAccessible(true);
                field.set(o, rs.getObject(key));
            }
            objects.add(o);
        }
        return objects;
    }

    public final static List<Object> objects(Class clazz) throws Exception {
        List<Object> objects = new ArrayList<>();
        String query = "SELECT * FROM " + ((MapToTable) clazz.getDeclaredAnnotations()[0]).value();
        Map<String, Field> mapping = allMappings.get(clazz);
        PreparedStatement psmt = Database.getConnection().prepareStatement(query);
        ResultSet rs = psmt.executeQuery();
        while (rs.next()) {
            Object o = Class.forName(clazz.getName()).newInstance();
            for (String key : mapping.keySet()) {
                java.lang.reflect.Field field = mapping.get(key).getField();
                field.setAccessible(true);
                field.set(o, rs.getObject(key));
            }
            objects.add(o);
        }
        return objects;
    }

    public final static List<Object> objects(Class clazz, List<Condition> conditions) throws Exception {
        List<Object> objects = new ArrayList<>();
        Map<String, Field> mapping = allMappings.get(clazz);
        String query = "SELECT * FROM " + ((MapToTable) clazz.getDeclaredAnnotations()[0]).value() + " WHERE ";

        String wheres = "";
        List<Object> vals = new ArrayList<>();
        int j = 0;
        for (Condition condition : conditions) {
            j++;
            Map<String, Object> conditionMap = new HashMap(condition.getCondition());
            if (condition instanceof ORCondition) {
                wheres += "";
                System.out.println("IN OR");
                for (String cond : conditionMap.keySet()) {
                    wheres += " " + cond + " OR";
                    System.out.println(cond);
                    vals.add(conditionMap.get(cond));
                }
                wheres = wheres.substring(0, wheres.length() - 2);
                wheres += "";
            } else if (condition instanceof ANDCondition) {
                System.out.println("IN AND");
                wheres += "";
                for (String cond : conditionMap.keySet()) {
                    wheres += cond + " AND";
                    vals.add(conditionMap.get(cond));
                }
                wheres = wheres.substring(0, wheres.length() - 3);
                wheres += "";
            } else {
                System.out.println("IN SIMPLE");
                if (j != 1) {
                    wheres += " AND ";
                }
                for (String cond : conditionMap.keySet()) {
                    wheres += cond;
                    vals.add(conditionMap.get(cond));
                }/*
                 if (conditions.toArray().length > 1) {
                 if (!conditions.toArray()[conditions.toArray().length - 1].equals(condition)) {
                 wheres += " ";
                 } else {
                 //wheres += " AND ";
                 }
                 }*/

                wheres += "";
            }
        }
        query += wheres + "";
        System.out.println(vals.toArray().length);
        System.out.println(query);
        PreparedStatement psmt = Database.getConnection().prepareStatement(query);
        int i = 1;
        for (Object obj : vals) {
            psmt.setObject(i, obj);
            i++;
        }
        ResultSet rs = psmt.executeQuery();

        while (rs.next()) {
            Object o = Class.forName(clazz.getName()).newInstance();
            for (String key : mapping.keySet()) {
                java.lang.reflect.Field field = mapping.get(key).getField();
                field.setAccessible(true);
                field.set(o, rs.getObject(key));
            }
            objects.add(o);
        }
        return objects;
    }

    public final static Object first(Class clazz, List<Condition> conditions) {
        try {
            return (objects(clazz, conditions)).get(0);
        } catch (Exception ex) {
            return null;
        }
    }

}
