package com.spongeli.shoppingmall.pojo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MallCateParamsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MallCateParamsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andAttrIdIsNull() {
            addCriterion("attr_id is null");
            return (Criteria) this;
        }

        public Criteria andAttrIdIsNotNull() {
            addCriterion("attr_id is not null");
            return (Criteria) this;
        }

        public Criteria andAttrIdEqualTo(Integer value) {
            addCriterion("attr_id =", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdNotEqualTo(Integer value) {
            addCriterion("attr_id <>", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdGreaterThan(Integer value) {
            addCriterion("attr_id >", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("attr_id >=", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdLessThan(Integer value) {
            addCriterion("attr_id <", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdLessThanOrEqualTo(Integer value) {
            addCriterion("attr_id <=", value, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdIn(List<Integer> values) {
            addCriterion("attr_id in", values, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdNotIn(List<Integer> values) {
            addCriterion("attr_id not in", values, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdBetween(Integer value1, Integer value2) {
            addCriterion("attr_id between", value1, value2, "attrId");
            return (Criteria) this;
        }

        public Criteria andAttrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("attr_id not between", value1, value2, "attrId");
            return (Criteria) this;
        }

        public Criteria andCateIdIsNull() {
            addCriterion("cate_id is null");
            return (Criteria) this;
        }

        public Criteria andCateIdIsNotNull() {
            addCriterion("cate_id is not null");
            return (Criteria) this;
        }

        public Criteria andCateIdEqualTo(Integer value) {
            addCriterion("cate_id =", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotEqualTo(Integer value) {
            addCriterion("cate_id <>", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdGreaterThan(Integer value) {
            addCriterion("cate_id >", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cate_id >=", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdLessThan(Integer value) {
            addCriterion("cate_id <", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdLessThanOrEqualTo(Integer value) {
            addCriterion("cate_id <=", value, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdIn(List<Integer> values) {
            addCriterion("cate_id in", values, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotIn(List<Integer> values) {
            addCriterion("cate_id not in", values, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdBetween(Integer value1, Integer value2) {
            addCriterion("cate_id between", value1, value2, "cateId");
            return (Criteria) this;
        }

        public Criteria andCateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cate_id not between", value1, value2, "cateId");
            return (Criteria) this;
        }

        public Criteria andAttrNameIsNull() {
            addCriterion("attr_name is null");
            return (Criteria) this;
        }

        public Criteria andAttrNameIsNotNull() {
            addCriterion("attr_name is not null");
            return (Criteria) this;
        }

        public Criteria andAttrNameEqualTo(String value) {
            addCriterion("attr_name =", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameNotEqualTo(String value) {
            addCriterion("attr_name <>", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameGreaterThan(String value) {
            addCriterion("attr_name >", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameGreaterThanOrEqualTo(String value) {
            addCriterion("attr_name >=", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameLessThan(String value) {
            addCriterion("attr_name <", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameLessThanOrEqualTo(String value) {
            addCriterion("attr_name <=", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameLike(String value) {
            addCriterion("attr_name like", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameNotLike(String value) {
            addCriterion("attr_name not like", value, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameIn(List<String> values) {
            addCriterion("attr_name in", values, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameNotIn(List<String> values) {
            addCriterion("attr_name not in", values, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameBetween(String value1, String value2) {
            addCriterion("attr_name between", value1, value2, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrNameNotBetween(String value1, String value2) {
            addCriterion("attr_name not between", value1, value2, "attrName");
            return (Criteria) this;
        }

        public Criteria andAttrTypeIsNull() {
            addCriterion("attr_type is null");
            return (Criteria) this;
        }

        public Criteria andAttrTypeIsNotNull() {
            addCriterion("attr_type is not null");
            return (Criteria) this;
        }

        public Criteria andAttrTypeEqualTo(String value) {
            addCriterion("attr_type =", value, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrTypeNotEqualTo(String value) {
            addCriterion("attr_type <>", value, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrTypeGreaterThan(String value) {
            addCriterion("attr_type >", value, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrTypeGreaterThanOrEqualTo(String value) {
            addCriterion("attr_type >=", value, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrTypeLessThan(String value) {
            addCriterion("attr_type <", value, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrTypeLessThanOrEqualTo(String value) {
            addCriterion("attr_type <=", value, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrTypeLike(String value) {
            addCriterion("attr_type like", value, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrTypeNotLike(String value) {
            addCriterion("attr_type not like", value, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrTypeIn(List<String> values) {
            addCriterion("attr_type in", values, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrTypeNotIn(List<String> values) {
            addCriterion("attr_type not in", values, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrTypeBetween(String value1, String value2) {
            addCriterion("attr_type between", value1, value2, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrTypeNotBetween(String value1, String value2) {
            addCriterion("attr_type not between", value1, value2, "attrType");
            return (Criteria) this;
        }

        public Criteria andAttrStatusIsNull() {
            addCriterion("attr_status is null");
            return (Criteria) this;
        }

        public Criteria andAttrStatusIsNotNull() {
            addCriterion("attr_status is not null");
            return (Criteria) this;
        }

        public Criteria andAttrStatusEqualTo(Byte value) {
            addCriterion("attr_status =", value, "attrStatus");
            return (Criteria) this;
        }

        public Criteria andAttrStatusNotEqualTo(Byte value) {
            addCriterion("attr_status <>", value, "attrStatus");
            return (Criteria) this;
        }

        public Criteria andAttrStatusGreaterThan(Byte value) {
            addCriterion("attr_status >", value, "attrStatus");
            return (Criteria) this;
        }

        public Criteria andAttrStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("attr_status >=", value, "attrStatus");
            return (Criteria) this;
        }

        public Criteria andAttrStatusLessThan(Byte value) {
            addCriterion("attr_status <", value, "attrStatus");
            return (Criteria) this;
        }

        public Criteria andAttrStatusLessThanOrEqualTo(Byte value) {
            addCriterion("attr_status <=", value, "attrStatus");
            return (Criteria) this;
        }

        public Criteria andAttrStatusIn(List<Byte> values) {
            addCriterion("attr_status in", values, "attrStatus");
            return (Criteria) this;
        }

        public Criteria andAttrStatusNotIn(List<Byte> values) {
            addCriterion("attr_status not in", values, "attrStatus");
            return (Criteria) this;
        }

        public Criteria andAttrStatusBetween(Byte value1, Byte value2) {
            addCriterion("attr_status between", value1, value2, "attrStatus");
            return (Criteria) this;
        }

        public Criteria andAttrStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("attr_status not between", value1, value2, "attrStatus");
            return (Criteria) this;
        }

        public Criteria andAttrListIsNull() {
            addCriterion("attr_list is null");
            return (Criteria) this;
        }

        public Criteria andAttrListIsNotNull() {
            addCriterion("attr_list is not null");
            return (Criteria) this;
        }

        public Criteria andAttrListEqualTo(String value) {
            addCriterion("attr_list =", value, "attrList");
            return (Criteria) this;
        }

        public Criteria andAttrListNotEqualTo(String value) {
            addCriterion("attr_list <>", value, "attrList");
            return (Criteria) this;
        }

        public Criteria andAttrListGreaterThan(String value) {
            addCriterion("attr_list >", value, "attrList");
            return (Criteria) this;
        }

        public Criteria andAttrListGreaterThanOrEqualTo(String value) {
            addCriterion("attr_list >=", value, "attrList");
            return (Criteria) this;
        }

        public Criteria andAttrListLessThan(String value) {
            addCriterion("attr_list <", value, "attrList");
            return (Criteria) this;
        }

        public Criteria andAttrListLessThanOrEqualTo(String value) {
            addCriterion("attr_list <=", value, "attrList");
            return (Criteria) this;
        }

        public Criteria andAttrListLike(String value) {
            addCriterion("attr_list like", value, "attrList");
            return (Criteria) this;
        }

        public Criteria andAttrListNotLike(String value) {
            addCriterion("attr_list not like", value, "attrList");
            return (Criteria) this;
        }

        public Criteria andAttrListIn(List<String> values) {
            addCriterion("attr_list in", values, "attrList");
            return (Criteria) this;
        }

        public Criteria andAttrListNotIn(List<String> values) {
            addCriterion("attr_list not in", values, "attrList");
            return (Criteria) this;
        }

        public Criteria andAttrListBetween(String value1, String value2) {
            addCriterion("attr_list between", value1, value2, "attrList");
            return (Criteria) this;
        }

        public Criteria andAttrListNotBetween(String value1, String value2) {
            addCriterion("attr_list not between", value1, value2, "attrList");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}