package com.gec.piecework.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShippingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShippingExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdWireIsNull() {
            addCriterion("id_wire is null");
            return (Criteria) this;
        }

        public Criteria andIdWireIsNotNull() {
            addCriterion("id_wire is not null");
            return (Criteria) this;
        }

        public Criteria andIdWireEqualTo(Integer value) {
            addCriterion("id_wire =", value, "idWire");
            return (Criteria) this;
        }

        public Criteria andIdWireNotEqualTo(Integer value) {
            addCriterion("id_wire <>", value, "idWire");
            return (Criteria) this;
        }

        public Criteria andIdWireGreaterThan(Integer value) {
            addCriterion("id_wire >", value, "idWire");
            return (Criteria) this;
        }

        public Criteria andIdWireGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_wire >=", value, "idWire");
            return (Criteria) this;
        }

        public Criteria andIdWireLessThan(Integer value) {
            addCriterion("id_wire <", value, "idWire");
            return (Criteria) this;
        }

        public Criteria andIdWireLessThanOrEqualTo(Integer value) {
            addCriterion("id_wire <=", value, "idWire");
            return (Criteria) this;
        }

        public Criteria andIdWireIn(List<Integer> values) {
            addCriterion("id_wire in", values, "idWire");
            return (Criteria) this;
        }

        public Criteria andIdWireNotIn(List<Integer> values) {
            addCriterion("id_wire not in", values, "idWire");
            return (Criteria) this;
        }

        public Criteria andIdWireBetween(Integer value1, Integer value2) {
            addCriterion("id_wire between", value1, value2, "idWire");
            return (Criteria) this;
        }

        public Criteria andIdWireNotBetween(Integer value1, Integer value2) {
            addCriterion("id_wire not between", value1, value2, "idWire");
            return (Criteria) this;
        }

        public Criteria andWireAmountIsNull() {
            addCriterion("wire_amount is null");
            return (Criteria) this;
        }

        public Criteria andWireAmountIsNotNull() {
            addCriterion("wire_amount is not null");
            return (Criteria) this;
        }

        public Criteria andWireAmountEqualTo(Integer value) {
            addCriterion("wire_amount =", value, "wireAmount");
            return (Criteria) this;
        }

        public Criteria andWireAmountNotEqualTo(Integer value) {
            addCriterion("wire_amount <>", value, "wireAmount");
            return (Criteria) this;
        }

        public Criteria andWireAmountGreaterThan(Integer value) {
            addCriterion("wire_amount >", value, "wireAmount");
            return (Criteria) this;
        }

        public Criteria andWireAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("wire_amount >=", value, "wireAmount");
            return (Criteria) this;
        }

        public Criteria andWireAmountLessThan(Integer value) {
            addCriterion("wire_amount <", value, "wireAmount");
            return (Criteria) this;
        }

        public Criteria andWireAmountLessThanOrEqualTo(Integer value) {
            addCriterion("wire_amount <=", value, "wireAmount");
            return (Criteria) this;
        }

        public Criteria andWireAmountIn(List<Integer> values) {
            addCriterion("wire_amount in", values, "wireAmount");
            return (Criteria) this;
        }

        public Criteria andWireAmountNotIn(List<Integer> values) {
            addCriterion("wire_amount not in", values, "wireAmount");
            return (Criteria) this;
        }

        public Criteria andWireAmountBetween(Integer value1, Integer value2) {
            addCriterion("wire_amount between", value1, value2, "wireAmount");
            return (Criteria) this;
        }

        public Criteria andWireAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("wire_amount not between", value1, value2, "wireAmount");
            return (Criteria) this;
        }

        public Criteria andChangesIsNull() {
            addCriterion("changes is null");
            return (Criteria) this;
        }

        public Criteria andChangesIsNotNull() {
            addCriterion("changes is not null");
            return (Criteria) this;
        }

        public Criteria andChangesEqualTo(String value) {
            addCriterion("changes =", value, "changes");
            return (Criteria) this;
        }

        public Criteria andChangesNotEqualTo(String value) {
            addCriterion("changes <>", value, "changes");
            return (Criteria) this;
        }

        public Criteria andChangesGreaterThan(String value) {
            addCriterion("changes >", value, "changes");
            return (Criteria) this;
        }

        public Criteria andChangesGreaterThanOrEqualTo(String value) {
            addCriterion("changes >=", value, "changes");
            return (Criteria) this;
        }

        public Criteria andChangesLessThan(String value) {
            addCriterion("changes <", value, "changes");
            return (Criteria) this;
        }

        public Criteria andChangesLessThanOrEqualTo(String value) {
            addCriterion("changes <=", value, "changes");
            return (Criteria) this;
        }

        public Criteria andChangesLike(String value) {
            addCriterion("changes like", value, "changes");
            return (Criteria) this;
        }

        public Criteria andChangesNotLike(String value) {
            addCriterion("changes not like", value, "changes");
            return (Criteria) this;
        }

        public Criteria andChangesIn(List<String> values) {
            addCriterion("changes in", values, "changes");
            return (Criteria) this;
        }

        public Criteria andChangesNotIn(List<String> values) {
            addCriterion("changes not in", values, "changes");
            return (Criteria) this;
        }

        public Criteria andChangesBetween(String value1, String value2) {
            addCriterion("changes between", value1, value2, "changes");
            return (Criteria) this;
        }

        public Criteria andChangesNotBetween(String value1, String value2) {
            addCriterion("changes not between", value1, value2, "changes");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNull() {
            addCriterion("creatTime is null");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNotNull() {
            addCriterion("creatTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreattimeEqualTo(Date value) {
            addCriterion("creatTime =", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotEqualTo(Date value) {
            addCriterion("creatTime <>", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThan(Date value) {
            addCriterion("creatTime >", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creatTime >=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThan(Date value) {
            addCriterion("creatTime <", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThanOrEqualTo(Date value) {
            addCriterion("creatTime <=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeIn(List<Date> values) {
            addCriterion("creatTime in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotIn(List<Date> values) {
            addCriterion("creatTime not in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeBetween(Date value1, Date value2) {
            addCriterion("creatTime between", value1, value2, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotBetween(Date value1, Date value2) {
            addCriterion("creatTime not between", value1, value2, "creattime");
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