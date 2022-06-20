package com.edu.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EvaluateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EvaluateExample() {
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

        public Criteria andEidIsNull() {
            addCriterion("eid is null");
            return (Criteria) this;
        }

        public Criteria andEidIsNotNull() {
            addCriterion("eid is not null");
            return (Criteria) this;
        }

        public Criteria andEidEqualTo(Integer value) {
            addCriterion("eid =", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotEqualTo(Integer value) {
            addCriterion("eid <>", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThan(Integer value) {
            addCriterion("eid >", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThanOrEqualTo(Integer value) {
            addCriterion("eid >=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThan(Integer value) {
            addCriterion("eid <", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThanOrEqualTo(Integer value) {
            addCriterion("eid <=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidIn(List<Integer> values) {
            addCriterion("eid in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotIn(List<Integer> values) {
            addCriterion("eid not in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidBetween(Integer value1, Integer value2) {
            addCriterion("eid between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotBetween(Integer value1, Integer value2) {
            addCriterion("eid not between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andEcontentIsNull() {
            addCriterion("econtent is null");
            return (Criteria) this;
        }

        public Criteria andEcontentIsNotNull() {
            addCriterion("econtent is not null");
            return (Criteria) this;
        }

        public Criteria andEcontentEqualTo(String value) {
            addCriterion("econtent =", value, "econtent");
            return (Criteria) this;
        }

        public Criteria andEcontentNotEqualTo(String value) {
            addCriterion("econtent <>", value, "econtent");
            return (Criteria) this;
        }

        public Criteria andEcontentGreaterThan(String value) {
            addCriterion("econtent >", value, "econtent");
            return (Criteria) this;
        }

        public Criteria andEcontentGreaterThanOrEqualTo(String value) {
            addCriterion("econtent >=", value, "econtent");
            return (Criteria) this;
        }

        public Criteria andEcontentLessThan(String value) {
            addCriterion("econtent <", value, "econtent");
            return (Criteria) this;
        }

        public Criteria andEcontentLessThanOrEqualTo(String value) {
            addCriterion("econtent <=", value, "econtent");
            return (Criteria) this;
        }

        public Criteria andEcontentLike(String value) {
            addCriterion("econtent like", value, "econtent");
            return (Criteria) this;
        }

        public Criteria andEcontentNotLike(String value) {
            addCriterion("econtent not like", value, "econtent");
            return (Criteria) this;
        }

        public Criteria andEcontentIn(List<String> values) {
            addCriterion("econtent in", values, "econtent");
            return (Criteria) this;
        }

        public Criteria andEcontentNotIn(List<String> values) {
            addCriterion("econtent not in", values, "econtent");
            return (Criteria) this;
        }

        public Criteria andEcontentBetween(String value1, String value2) {
            addCriterion("econtent between", value1, value2, "econtent");
            return (Criteria) this;
        }

        public Criteria andEcontentNotBetween(String value1, String value2) {
            addCriterion("econtent not between", value1, value2, "econtent");
            return (Criteria) this;
        }

        public Criteria andBFkIsNull() {
            addCriterion("b_fk is null");
            return (Criteria) this;
        }

        public Criteria andBFkIsNotNull() {
            addCriterion("b_fk is not null");
            return (Criteria) this;
        }

        public Criteria andBFkEqualTo(Integer value) {
            addCriterion("b_fk =", value, "bFk");
            return (Criteria) this;
        }

        public Criteria andBFkNotEqualTo(Integer value) {
            addCriterion("b_fk <>", value, "bFk");
            return (Criteria) this;
        }

        public Criteria andBFkGreaterThan(Integer value) {
            addCriterion("b_fk >", value, "bFk");
            return (Criteria) this;
        }

        public Criteria andBFkGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_fk >=", value, "bFk");
            return (Criteria) this;
        }

        public Criteria andBFkLessThan(Integer value) {
            addCriterion("b_fk <", value, "bFk");
            return (Criteria) this;
        }

        public Criteria andBFkLessThanOrEqualTo(Integer value) {
            addCriterion("b_fk <=", value, "bFk");
            return (Criteria) this;
        }

        public Criteria andBFkIn(List<Integer> values) {
            addCriterion("b_fk in", values, "bFk");
            return (Criteria) this;
        }

        public Criteria andBFkNotIn(List<Integer> values) {
            addCriterion("b_fk not in", values, "bFk");
            return (Criteria) this;
        }

        public Criteria andBFkBetween(Integer value1, Integer value2) {
            addCriterion("b_fk between", value1, value2, "bFk");
            return (Criteria) this;
        }

        public Criteria andBFkNotBetween(Integer value1, Integer value2) {
            addCriterion("b_fk not between", value1, value2, "bFk");
            return (Criteria) this;
        }

        public Criteria andUFkIsNull() {
            addCriterion("u_fk is null");
            return (Criteria) this;
        }

        public Criteria andUFkIsNotNull() {
            addCriterion("u_fk is not null");
            return (Criteria) this;
        }

        public Criteria andUFkEqualTo(Integer value) {
            addCriterion("u_fk =", value, "uFk");
            return (Criteria) this;
        }

        public Criteria andUFkNotEqualTo(Integer value) {
            addCriterion("u_fk <>", value, "uFk");
            return (Criteria) this;
        }

        public Criteria andUFkGreaterThan(Integer value) {
            addCriterion("u_fk >", value, "uFk");
            return (Criteria) this;
        }

        public Criteria andUFkGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_fk >=", value, "uFk");
            return (Criteria) this;
        }

        public Criteria andUFkLessThan(Integer value) {
            addCriterion("u_fk <", value, "uFk");
            return (Criteria) this;
        }

        public Criteria andUFkLessThanOrEqualTo(Integer value) {
            addCriterion("u_fk <=", value, "uFk");
            return (Criteria) this;
        }

        public Criteria andUFkIn(List<Integer> values) {
            addCriterion("u_fk in", values, "uFk");
            return (Criteria) this;
        }

        public Criteria andUFkNotIn(List<Integer> values) {
            addCriterion("u_fk not in", values, "uFk");
            return (Criteria) this;
        }

        public Criteria andUFkBetween(Integer value1, Integer value2) {
            addCriterion("u_fk between", value1, value2, "uFk");
            return (Criteria) this;
        }

        public Criteria andUFkNotBetween(Integer value1, Integer value2) {
            addCriterion("u_fk not between", value1, value2, "uFk");
            return (Criteria) this;
        }

        public Criteria andEtimeIsNull() {
            addCriterion("etime is null");
            return (Criteria) this;
        }

        public Criteria andEtimeIsNotNull() {
            addCriterion("etime is not null");
            return (Criteria) this;
        }

        public Criteria andEtimeEqualTo(Date value) {
            addCriterionForJDBCDate("etime =", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("etime <>", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("etime >", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("etime >=", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeLessThan(Date value) {
            addCriterionForJDBCDate("etime <", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("etime <=", value, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeIn(List<Date> values) {
            addCriterionForJDBCDate("etime in", values, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("etime not in", values, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("etime between", value1, value2, "etime");
            return (Criteria) this;
        }

        public Criteria andEtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("etime not between", value1, value2, "etime");
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