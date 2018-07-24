package com.bdyh.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BenefitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BenefitExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNull() {
            addCriterion("teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNotNull() {
            addCriterion("teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdEqualTo(Integer value) {
            addCriterion("teacher_id =", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotEqualTo(Integer value) {
            addCriterion("teacher_id <>", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThan(Integer value) {
            addCriterion("teacher_id >", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacher_id >=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThan(Integer value) {
            addCriterion("teacher_id <", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThanOrEqualTo(Integer value) {
            addCriterion("teacher_id <=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIn(List<Integer> values) {
            addCriterion("teacher_id in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotIn(List<Integer> values) {
            addCriterion("teacher_id not in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdBetween(Integer value1, Integer value2) {
            addCriterion("teacher_id between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("teacher_id not between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNull() {
            addCriterion("agent_id is null");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNotNull() {
            addCriterion("agent_id is not null");
            return (Criteria) this;
        }

        public Criteria andAgentIdEqualTo(Integer value) {
            addCriterion("agent_id =", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotEqualTo(Integer value) {
            addCriterion("agent_id <>", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThan(Integer value) {
            addCriterion("agent_id >", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("agent_id >=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThan(Integer value) {
            addCriterion("agent_id <", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThanOrEqualTo(Integer value) {
            addCriterion("agent_id <=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdIn(List<Integer> values) {
            addCriterion("agent_id in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotIn(List<Integer> values) {
            addCriterion("agent_id not in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdBetween(Integer value1, Integer value2) {
            addCriterion("agent_id between", value1, value2, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("agent_id not between", value1, value2, "agentId");
            return (Criteria) this;
        }

        public Criteria andTeacherBenefitIsNull() {
            addCriterion("teacher_benefit is null");
            return (Criteria) this;
        }

        public Criteria andTeacherBenefitIsNotNull() {
            addCriterion("teacher_benefit is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherBenefitEqualTo(BigDecimal value) {
            addCriterion("teacher_benefit =", value, "teacherBenefit");
            return (Criteria) this;
        }

        public Criteria andTeacherBenefitNotEqualTo(BigDecimal value) {
            addCriterion("teacher_benefit <>", value, "teacherBenefit");
            return (Criteria) this;
        }

        public Criteria andTeacherBenefitGreaterThan(BigDecimal value) {
            addCriterion("teacher_benefit >", value, "teacherBenefit");
            return (Criteria) this;
        }

        public Criteria andTeacherBenefitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("teacher_benefit >=", value, "teacherBenefit");
            return (Criteria) this;
        }

        public Criteria andTeacherBenefitLessThan(BigDecimal value) {
            addCriterion("teacher_benefit <", value, "teacherBenefit");
            return (Criteria) this;
        }

        public Criteria andTeacherBenefitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("teacher_benefit <=", value, "teacherBenefit");
            return (Criteria) this;
        }

        public Criteria andTeacherBenefitIn(List<BigDecimal> values) {
            addCriterion("teacher_benefit in", values, "teacherBenefit");
            return (Criteria) this;
        }

        public Criteria andTeacherBenefitNotIn(List<BigDecimal> values) {
            addCriterion("teacher_benefit not in", values, "teacherBenefit");
            return (Criteria) this;
        }

        public Criteria andTeacherBenefitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("teacher_benefit between", value1, value2, "teacherBenefit");
            return (Criteria) this;
        }

        public Criteria andTeacherBenefitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("teacher_benefit not between", value1, value2, "teacherBenefit");
            return (Criteria) this;
        }

        public Criteria andAgentBenefitIsNull() {
            addCriterion("agent_benefit is null");
            return (Criteria) this;
        }

        public Criteria andAgentBenefitIsNotNull() {
            addCriterion("agent_benefit is not null");
            return (Criteria) this;
        }

        public Criteria andAgentBenefitEqualTo(BigDecimal value) {
            addCriterion("agent_benefit =", value, "agentBenefit");
            return (Criteria) this;
        }

        public Criteria andAgentBenefitNotEqualTo(BigDecimal value) {
            addCriterion("agent_benefit <>", value, "agentBenefit");
            return (Criteria) this;
        }

        public Criteria andAgentBenefitGreaterThan(BigDecimal value) {
            addCriterion("agent_benefit >", value, "agentBenefit");
            return (Criteria) this;
        }

        public Criteria andAgentBenefitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("agent_benefit >=", value, "agentBenefit");
            return (Criteria) this;
        }

        public Criteria andAgentBenefitLessThan(BigDecimal value) {
            addCriterion("agent_benefit <", value, "agentBenefit");
            return (Criteria) this;
        }

        public Criteria andAgentBenefitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("agent_benefit <=", value, "agentBenefit");
            return (Criteria) this;
        }

        public Criteria andAgentBenefitIn(List<BigDecimal> values) {
            addCriterion("agent_benefit in", values, "agentBenefit");
            return (Criteria) this;
        }

        public Criteria andAgentBenefitNotIn(List<BigDecimal> values) {
            addCriterion("agent_benefit not in", values, "agentBenefit");
            return (Criteria) this;
        }

        public Criteria andAgentBenefitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("agent_benefit between", value1, value2, "agentBenefit");
            return (Criteria) this;
        }

        public Criteria andAgentBenefitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("agent_benefit not between", value1, value2, "agentBenefit");
            return (Criteria) this;
        }

        public Criteria andAdminBenefitIsNull() {
            addCriterion("admin_benefit is null");
            return (Criteria) this;
        }

        public Criteria andAdminBenefitIsNotNull() {
            addCriterion("admin_benefit is not null");
            return (Criteria) this;
        }

        public Criteria andAdminBenefitEqualTo(BigDecimal value) {
            addCriterion("admin_benefit =", value, "adminBenefit");
            return (Criteria) this;
        }

        public Criteria andAdminBenefitNotEqualTo(BigDecimal value) {
            addCriterion("admin_benefit <>", value, "adminBenefit");
            return (Criteria) this;
        }

        public Criteria andAdminBenefitGreaterThan(BigDecimal value) {
            addCriterion("admin_benefit >", value, "adminBenefit");
            return (Criteria) this;
        }

        public Criteria andAdminBenefitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("admin_benefit >=", value, "adminBenefit");
            return (Criteria) this;
        }

        public Criteria andAdminBenefitLessThan(BigDecimal value) {
            addCriterion("admin_benefit <", value, "adminBenefit");
            return (Criteria) this;
        }

        public Criteria andAdminBenefitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("admin_benefit <=", value, "adminBenefit");
            return (Criteria) this;
        }

        public Criteria andAdminBenefitIn(List<BigDecimal> values) {
            addCriterion("admin_benefit in", values, "adminBenefit");
            return (Criteria) this;
        }

        public Criteria andAdminBenefitNotIn(List<BigDecimal> values) {
            addCriterion("admin_benefit not in", values, "adminBenefit");
            return (Criteria) this;
        }

        public Criteria andAdminBenefitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("admin_benefit between", value1, value2, "adminBenefit");
            return (Criteria) this;
        }

        public Criteria andAdminBenefitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("admin_benefit not between", value1, value2, "adminBenefit");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
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