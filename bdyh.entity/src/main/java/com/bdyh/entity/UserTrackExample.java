package com.bdyh.entity;

import java.util.ArrayList;
import java.util.List;

public class UserTrackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserTrackExample() {
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

        public Criteria andUtidIsNull() {
            addCriterion("utid is null");
            return (Criteria) this;
        }

        public Criteria andUtidIsNotNull() {
            addCriterion("utid is not null");
            return (Criteria) this;
        }

        public Criteria andUtidEqualTo(Integer value) {
            addCriterion("utid =", value, "utid");
            return (Criteria) this;
        }

        public Criteria andUtidNotEqualTo(Integer value) {
            addCriterion("utid <>", value, "utid");
            return (Criteria) this;
        }

        public Criteria andUtidGreaterThan(Integer value) {
            addCriterion("utid >", value, "utid");
            return (Criteria) this;
        }

        public Criteria andUtidGreaterThanOrEqualTo(Integer value) {
            addCriterion("utid >=", value, "utid");
            return (Criteria) this;
        }

        public Criteria andUtidLessThan(Integer value) {
            addCriterion("utid <", value, "utid");
            return (Criteria) this;
        }

        public Criteria andUtidLessThanOrEqualTo(Integer value) {
            addCriterion("utid <=", value, "utid");
            return (Criteria) this;
        }

        public Criteria andUtidIn(List<Integer> values) {
            addCriterion("utid in", values, "utid");
            return (Criteria) this;
        }

        public Criteria andUtidNotIn(List<Integer> values) {
            addCriterion("utid not in", values, "utid");
            return (Criteria) this;
        }

        public Criteria andUtidBetween(Integer value1, Integer value2) {
            addCriterion("utid between", value1, value2, "utid");
            return (Criteria) this;
        }

        public Criteria andUtidNotBetween(Integer value1, Integer value2) {
            addCriterion("utid not between", value1, value2, "utid");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("openid is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openid is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openid =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openid <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openid >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openid >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openid <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openid <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openid like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openid not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openid in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openid not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openid between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openid not between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(Integer value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(Integer value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(Integer value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(Integer value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(Integer value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<Integer> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<Integer> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(Integer value1, Integer value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andTrackTimeIsNull() {
            addCriterion("track_time is null");
            return (Criteria) this;
        }

        public Criteria andTrackTimeIsNotNull() {
            addCriterion("track_time is not null");
            return (Criteria) this;
        }

        public Criteria andTrackTimeEqualTo(String value) {
            addCriterion("track_time =", value, "trackTime");
            return (Criteria) this;
        }

        public Criteria andTrackTimeNotEqualTo(String value) {
            addCriterion("track_time <>", value, "trackTime");
            return (Criteria) this;
        }

        public Criteria andTrackTimeGreaterThan(String value) {
            addCriterion("track_time >", value, "trackTime");
            return (Criteria) this;
        }

        public Criteria andTrackTimeGreaterThanOrEqualTo(String value) {
            addCriterion("track_time >=", value, "trackTime");
            return (Criteria) this;
        }

        public Criteria andTrackTimeLessThan(String value) {
            addCriterion("track_time <", value, "trackTime");
            return (Criteria) this;
        }

        public Criteria andTrackTimeLessThanOrEqualTo(String value) {
            addCriterion("track_time <=", value, "trackTime");
            return (Criteria) this;
        }

        public Criteria andTrackTimeLike(String value) {
            addCriterion("track_time like", value, "trackTime");
            return (Criteria) this;
        }

        public Criteria andTrackTimeNotLike(String value) {
            addCriterion("track_time not like", value, "trackTime");
            return (Criteria) this;
        }

        public Criteria andTrackTimeIn(List<String> values) {
            addCriterion("track_time in", values, "trackTime");
            return (Criteria) this;
        }

        public Criteria andTrackTimeNotIn(List<String> values) {
            addCriterion("track_time not in", values, "trackTime");
            return (Criteria) this;
        }

        public Criteria andTrackTimeBetween(String value1, String value2) {
            addCriterion("track_time between", value1, value2, "trackTime");
            return (Criteria) this;
        }

        public Criteria andTrackTimeNotBetween(String value1, String value2) {
            addCriterion("track_time not between", value1, value2, "trackTime");
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