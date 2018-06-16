package com.bdyh.entity;

import java.util.ArrayList;
import java.util.List;

public class CourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseExample() {
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

        public Criteria andLessionNumIsNull() {
            addCriterion("lession_num is null");
            return (Criteria) this;
        }

        public Criteria andLessionNumIsNotNull() {
            addCriterion("lession_num is not null");
            return (Criteria) this;
        }

        public Criteria andLessionNumEqualTo(Integer value) {
            addCriterion("lession_num =", value, "lessionNum");
            return (Criteria) this;
        }

        public Criteria andLessionNumNotEqualTo(Integer value) {
            addCriterion("lession_num <>", value, "lessionNum");
            return (Criteria) this;
        }

        public Criteria andLessionNumGreaterThan(Integer value) {
            addCriterion("lession_num >", value, "lessionNum");
            return (Criteria) this;
        }

        public Criteria andLessionNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("lession_num >=", value, "lessionNum");
            return (Criteria) this;
        }

        public Criteria andLessionNumLessThan(Integer value) {
            addCriterion("lession_num <", value, "lessionNum");
            return (Criteria) this;
        }

        public Criteria andLessionNumLessThanOrEqualTo(Integer value) {
            addCriterion("lession_num <=", value, "lessionNum");
            return (Criteria) this;
        }

        public Criteria andLessionNumIn(List<Integer> values) {
            addCriterion("lession_num in", values, "lessionNum");
            return (Criteria) this;
        }

        public Criteria andLessionNumNotIn(List<Integer> values) {
            addCriterion("lession_num not in", values, "lessionNum");
            return (Criteria) this;
        }

        public Criteria andLessionNumBetween(Integer value1, Integer value2) {
            addCriterion("lession_num between", value1, value2, "lessionNum");
            return (Criteria) this;
        }

        public Criteria andLessionNumNotBetween(Integer value1, Integer value2) {
            addCriterion("lession_num not between", value1, value2, "lessionNum");
            return (Criteria) this;
        }

        public Criteria andCourseLevelIsNull() {
            addCriterion("course_level is null");
            return (Criteria) this;
        }

        public Criteria andCourseLevelIsNotNull() {
            addCriterion("course_level is not null");
            return (Criteria) this;
        }

        public Criteria andCourseLevelEqualTo(Integer value) {
            addCriterion("course_level =", value, "courseLevel");
            return (Criteria) this;
        }

        public Criteria andCourseLevelNotEqualTo(Integer value) {
            addCriterion("course_level <>", value, "courseLevel");
            return (Criteria) this;
        }

        public Criteria andCourseLevelGreaterThan(Integer value) {
            addCriterion("course_level >", value, "courseLevel");
            return (Criteria) this;
        }

        public Criteria andCourseLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_level >=", value, "courseLevel");
            return (Criteria) this;
        }

        public Criteria andCourseLevelLessThan(Integer value) {
            addCriterion("course_level <", value, "courseLevel");
            return (Criteria) this;
        }

        public Criteria andCourseLevelLessThanOrEqualTo(Integer value) {
            addCriterion("course_level <=", value, "courseLevel");
            return (Criteria) this;
        }

        public Criteria andCourseLevelIn(List<Integer> values) {
            addCriterion("course_level in", values, "courseLevel");
            return (Criteria) this;
        }

        public Criteria andCourseLevelNotIn(List<Integer> values) {
            addCriterion("course_level not in", values, "courseLevel");
            return (Criteria) this;
        }

        public Criteria andCourseLevelBetween(Integer value1, Integer value2) {
            addCriterion("course_level between", value1, value2, "courseLevel");
            return (Criteria) this;
        }

        public Criteria andCourseLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("course_level not between", value1, value2, "courseLevel");
            return (Criteria) this;
        }

        public Criteria andCoursePriceIsNull() {
            addCriterion("course_price is null");
            return (Criteria) this;
        }

        public Criteria andCoursePriceIsNotNull() {
            addCriterion("course_price is not null");
            return (Criteria) this;
        }

        public Criteria andCoursePriceEqualTo(Double value) {
            addCriterion("course_price =", value, "coursePrice");
            return (Criteria) this;
        }

        public Criteria andCoursePriceNotEqualTo(Double value) {
            addCriterion("course_price <>", value, "coursePrice");
            return (Criteria) this;
        }

        public Criteria andCoursePriceGreaterThan(Double value) {
            addCriterion("course_price >", value, "coursePrice");
            return (Criteria) this;
        }

        public Criteria andCoursePriceGreaterThanOrEqualTo(Double value) {
            addCriterion("course_price >=", value, "coursePrice");
            return (Criteria) this;
        }

        public Criteria andCoursePriceLessThan(Double value) {
            addCriterion("course_price <", value, "coursePrice");
            return (Criteria) this;
        }

        public Criteria andCoursePriceLessThanOrEqualTo(Double value) {
            addCriterion("course_price <=", value, "coursePrice");
            return (Criteria) this;
        }

        public Criteria andCoursePriceIn(List<Double> values) {
            addCriterion("course_price in", values, "coursePrice");
            return (Criteria) this;
        }

        public Criteria andCoursePriceNotIn(List<Double> values) {
            addCriterion("course_price not in", values, "coursePrice");
            return (Criteria) this;
        }

        public Criteria andCoursePriceBetween(Double value1, Double value2) {
            addCriterion("course_price between", value1, value2, "coursePrice");
            return (Criteria) this;
        }

        public Criteria andCoursePriceNotBetween(Double value1, Double value2) {
            addCriterion("course_price not between", value1, value2, "coursePrice");
            return (Criteria) this;
        }

        public Criteria andCourseDescIsNull() {
            addCriterion("course_desc is null");
            return (Criteria) this;
        }

        public Criteria andCourseDescIsNotNull() {
            addCriterion("course_desc is not null");
            return (Criteria) this;
        }

        public Criteria andCourseDescEqualTo(String value) {
            addCriterion("course_desc =", value, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseDescNotEqualTo(String value) {
            addCriterion("course_desc <>", value, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseDescGreaterThan(String value) {
            addCriterion("course_desc >", value, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseDescGreaterThanOrEqualTo(String value) {
            addCriterion("course_desc >=", value, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseDescLessThan(String value) {
            addCriterion("course_desc <", value, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseDescLessThanOrEqualTo(String value) {
            addCriterion("course_desc <=", value, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseDescLike(String value) {
            addCriterion("course_desc like", value, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseDescNotLike(String value) {
            addCriterion("course_desc not like", value, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseDescIn(List<String> values) {
            addCriterion("course_desc in", values, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseDescNotIn(List<String> values) {
            addCriterion("course_desc not in", values, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseDescBetween(String value1, String value2) {
            addCriterion("course_desc between", value1, value2, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseDescNotBetween(String value1, String value2) {
            addCriterion("course_desc not between", value1, value2, "courseDesc");
            return (Criteria) this;
        }

        public Criteria andCourseImgIsNull() {
            addCriterion("course_img is null");
            return (Criteria) this;
        }

        public Criteria andCourseImgIsNotNull() {
            addCriterion("course_img is not null");
            return (Criteria) this;
        }

        public Criteria andCourseImgEqualTo(String value) {
            addCriterion("course_img =", value, "courseImg");
            return (Criteria) this;
        }

        public Criteria andCourseImgNotEqualTo(String value) {
            addCriterion("course_img <>", value, "courseImg");
            return (Criteria) this;
        }

        public Criteria andCourseImgGreaterThan(String value) {
            addCriterion("course_img >", value, "courseImg");
            return (Criteria) this;
        }

        public Criteria andCourseImgGreaterThanOrEqualTo(String value) {
            addCriterion("course_img >=", value, "courseImg");
            return (Criteria) this;
        }

        public Criteria andCourseImgLessThan(String value) {
            addCriterion("course_img <", value, "courseImg");
            return (Criteria) this;
        }

        public Criteria andCourseImgLessThanOrEqualTo(String value) {
            addCriterion("course_img <=", value, "courseImg");
            return (Criteria) this;
        }

        public Criteria andCourseImgLike(String value) {
            addCriterion("course_img like", value, "courseImg");
            return (Criteria) this;
        }

        public Criteria andCourseImgNotLike(String value) {
            addCriterion("course_img not like", value, "courseImg");
            return (Criteria) this;
        }

        public Criteria andCourseImgIn(List<String> values) {
            addCriterion("course_img in", values, "courseImg");
            return (Criteria) this;
        }

        public Criteria andCourseImgNotIn(List<String> values) {
            addCriterion("course_img not in", values, "courseImg");
            return (Criteria) this;
        }

        public Criteria andCourseImgBetween(String value1, String value2) {
            addCriterion("course_img between", value1, value2, "courseImg");
            return (Criteria) this;
        }

        public Criteria andCourseImgNotBetween(String value1, String value2) {
            addCriterion("course_img not between", value1, value2, "courseImg");
            return (Criteria) this;
        }

        public Criteria andCourseIntroIsNull() {
            addCriterion("course_intro is null");
            return (Criteria) this;
        }

        public Criteria andCourseIntroIsNotNull() {
            addCriterion("course_intro is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIntroEqualTo(String value) {
            addCriterion("course_intro =", value, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseIntroNotEqualTo(String value) {
            addCriterion("course_intro <>", value, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseIntroGreaterThan(String value) {
            addCriterion("course_intro >", value, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseIntroGreaterThanOrEqualTo(String value) {
            addCriterion("course_intro >=", value, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseIntroLessThan(String value) {
            addCriterion("course_intro <", value, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseIntroLessThanOrEqualTo(String value) {
            addCriterion("course_intro <=", value, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseIntroLike(String value) {
            addCriterion("course_intro like", value, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseIntroNotLike(String value) {
            addCriterion("course_intro not like", value, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseIntroIn(List<String> values) {
            addCriterion("course_intro in", values, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseIntroNotIn(List<String> values) {
            addCriterion("course_intro not in", values, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseIntroBetween(String value1, String value2) {
            addCriterion("course_intro between", value1, value2, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseIntroNotBetween(String value1, String value2) {
            addCriterion("course_intro not between", value1, value2, "courseIntro");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNull() {
            addCriterion("course_name is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("course_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("course_name =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("course_name <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("course_name >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("course_name >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("course_name <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("course_name <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("course_name like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("course_name not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("course_name in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("course_name not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("course_name between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("course_name not between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseRecommendIsNull() {
            addCriterion("course_recommend is null");
            return (Criteria) this;
        }

        public Criteria andCourseRecommendIsNotNull() {
            addCriterion("course_recommend is not null");
            return (Criteria) this;
        }

        public Criteria andCourseRecommendEqualTo(Integer value) {
            addCriterion("course_recommend =", value, "courseRecommend");
            return (Criteria) this;
        }

        public Criteria andCourseRecommendNotEqualTo(Integer value) {
            addCriterion("course_recommend <>", value, "courseRecommend");
            return (Criteria) this;
        }

        public Criteria andCourseRecommendGreaterThan(Integer value) {
            addCriterion("course_recommend >", value, "courseRecommend");
            return (Criteria) this;
        }

        public Criteria andCourseRecommendGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_recommend >=", value, "courseRecommend");
            return (Criteria) this;
        }

        public Criteria andCourseRecommendLessThan(Integer value) {
            addCriterion("course_recommend <", value, "courseRecommend");
            return (Criteria) this;
        }

        public Criteria andCourseRecommendLessThanOrEqualTo(Integer value) {
            addCriterion("course_recommend <=", value, "courseRecommend");
            return (Criteria) this;
        }

        public Criteria andCourseRecommendIn(List<Integer> values) {
            addCriterion("course_recommend in", values, "courseRecommend");
            return (Criteria) this;
        }

        public Criteria andCourseRecommendNotIn(List<Integer> values) {
            addCriterion("course_recommend not in", values, "courseRecommend");
            return (Criteria) this;
        }

        public Criteria andCourseRecommendBetween(Integer value1, Integer value2) {
            addCriterion("course_recommend between", value1, value2, "courseRecommend");
            return (Criteria) this;
        }

        public Criteria andCourseRecommendNotBetween(Integer value1, Integer value2) {
            addCriterion("course_recommend not between", value1, value2, "courseRecommend");
            return (Criteria) this;
        }

        public Criteria andCourseDifficultyIsNull() {
            addCriterion("course_difficulty is null");
            return (Criteria) this;
        }

        public Criteria andCourseDifficultyIsNotNull() {
            addCriterion("course_difficulty is not null");
            return (Criteria) this;
        }

        public Criteria andCourseDifficultyEqualTo(Integer value) {
            addCriterion("course_difficulty =", value, "courseDifficulty");
            return (Criteria) this;
        }

        public Criteria andCourseDifficultyNotEqualTo(Integer value) {
            addCriterion("course_difficulty <>", value, "courseDifficulty");
            return (Criteria) this;
        }

        public Criteria andCourseDifficultyGreaterThan(Integer value) {
            addCriterion("course_difficulty >", value, "courseDifficulty");
            return (Criteria) this;
        }

        public Criteria andCourseDifficultyGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_difficulty >=", value, "courseDifficulty");
            return (Criteria) this;
        }

        public Criteria andCourseDifficultyLessThan(Integer value) {
            addCriterion("course_difficulty <", value, "courseDifficulty");
            return (Criteria) this;
        }

        public Criteria andCourseDifficultyLessThanOrEqualTo(Integer value) {
            addCriterion("course_difficulty <=", value, "courseDifficulty");
            return (Criteria) this;
        }

        public Criteria andCourseDifficultyIn(List<Integer> values) {
            addCriterion("course_difficulty in", values, "courseDifficulty");
            return (Criteria) this;
        }

        public Criteria andCourseDifficultyNotIn(List<Integer> values) {
            addCriterion("course_difficulty not in", values, "courseDifficulty");
            return (Criteria) this;
        }

        public Criteria andCourseDifficultyBetween(Integer value1, Integer value2) {
            addCriterion("course_difficulty between", value1, value2, "courseDifficulty");
            return (Criteria) this;
        }

        public Criteria andCourseDifficultyNotBetween(Integer value1, Integer value2) {
            addCriterion("course_difficulty not between", value1, value2, "courseDifficulty");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIsNull() {
            addCriterion("course_type is null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIsNotNull() {
            addCriterion("course_type is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeEqualTo(String value) {
            addCriterion("course_type =", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotEqualTo(String value) {
            addCriterion("course_type <>", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeGreaterThan(String value) {
            addCriterion("course_type >", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("course_type >=", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLessThan(String value) {
            addCriterion("course_type <", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLessThanOrEqualTo(String value) {
            addCriterion("course_type <=", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLike(String value) {
            addCriterion("course_type like", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotLike(String value) {
            addCriterion("course_type not like", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIn(List<String> values) {
            addCriterion("course_type in", values, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotIn(List<String> values) {
            addCriterion("course_type not in", values, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeBetween(String value1, String value2) {
            addCriterion("course_type between", value1, value2, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotBetween(String value1, String value2) {
            addCriterion("course_type not between", value1, value2, "courseType");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIsNull() {
            addCriterion("district_id is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIsNotNull() {
            addCriterion("district_id is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictIdEqualTo(Integer value) {
            addCriterion("district_id =", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotEqualTo(Integer value) {
            addCriterion("district_id <>", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThan(Integer value) {
            addCriterion("district_id >", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("district_id >=", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThan(Integer value) {
            addCriterion("district_id <", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThanOrEqualTo(Integer value) {
            addCriterion("district_id <=", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIn(List<Integer> values) {
            addCriterion("district_id in", values, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotIn(List<Integer> values) {
            addCriterion("district_id not in", values, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdBetween(Integer value1, Integer value2) {
            addCriterion("district_id between", value1, value2, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotBetween(Integer value1, Integer value2) {
            addCriterion("district_id not between", value1, value2, "districtId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCollectNumberIsNull() {
            addCriterion("collect_number is null");
            return (Criteria) this;
        }

        public Criteria andCollectNumberIsNotNull() {
            addCriterion("collect_number is not null");
            return (Criteria) this;
        }

        public Criteria andCollectNumberEqualTo(Integer value) {
            addCriterion("collect_number =", value, "collectNumber");
            return (Criteria) this;
        }

        public Criteria andCollectNumberNotEqualTo(Integer value) {
            addCriterion("collect_number <>", value, "collectNumber");
            return (Criteria) this;
        }

        public Criteria andCollectNumberGreaterThan(Integer value) {
            addCriterion("collect_number >", value, "collectNumber");
            return (Criteria) this;
        }

        public Criteria andCollectNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_number >=", value, "collectNumber");
            return (Criteria) this;
        }

        public Criteria andCollectNumberLessThan(Integer value) {
            addCriterion("collect_number <", value, "collectNumber");
            return (Criteria) this;
        }

        public Criteria andCollectNumberLessThanOrEqualTo(Integer value) {
            addCriterion("collect_number <=", value, "collectNumber");
            return (Criteria) this;
        }

        public Criteria andCollectNumberIn(List<Integer> values) {
            addCriterion("collect_number in", values, "collectNumber");
            return (Criteria) this;
        }

        public Criteria andCollectNumberNotIn(List<Integer> values) {
            addCriterion("collect_number not in", values, "collectNumber");
            return (Criteria) this;
        }

        public Criteria andCollectNumberBetween(Integer value1, Integer value2) {
            addCriterion("collect_number between", value1, value2, "collectNumber");
            return (Criteria) this;
        }

        public Criteria andCollectNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_number not between", value1, value2, "collectNumber");
            return (Criteria) this;
        }

        public Criteria andFlowNumberIsNull() {
            addCriterion("flow_number is null");
            return (Criteria) this;
        }

        public Criteria andFlowNumberIsNotNull() {
            addCriterion("flow_number is not null");
            return (Criteria) this;
        }

        public Criteria andFlowNumberEqualTo(Integer value) {
            addCriterion("flow_number =", value, "flowNumber");
            return (Criteria) this;
        }

        public Criteria andFlowNumberNotEqualTo(Integer value) {
            addCriterion("flow_number <>", value, "flowNumber");
            return (Criteria) this;
        }

        public Criteria andFlowNumberGreaterThan(Integer value) {
            addCriterion("flow_number >", value, "flowNumber");
            return (Criteria) this;
        }

        public Criteria andFlowNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_number >=", value, "flowNumber");
            return (Criteria) this;
        }

        public Criteria andFlowNumberLessThan(Integer value) {
            addCriterion("flow_number <", value, "flowNumber");
            return (Criteria) this;
        }

        public Criteria andFlowNumberLessThanOrEqualTo(Integer value) {
            addCriterion("flow_number <=", value, "flowNumber");
            return (Criteria) this;
        }

        public Criteria andFlowNumberIn(List<Integer> values) {
            addCriterion("flow_number in", values, "flowNumber");
            return (Criteria) this;
        }

        public Criteria andFlowNumberNotIn(List<Integer> values) {
            addCriterion("flow_number not in", values, "flowNumber");
            return (Criteria) this;
        }

        public Criteria andFlowNumberBetween(Integer value1, Integer value2) {
            addCriterion("flow_number between", value1, value2, "flowNumber");
            return (Criteria) this;
        }

        public Criteria andFlowNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_number not between", value1, value2, "flowNumber");
            return (Criteria) this;
        }

        public Criteria andBenefitIsNull() {
            addCriterion("benefit is null");
            return (Criteria) this;
        }

        public Criteria andBenefitIsNotNull() {
            addCriterion("benefit is not null");
            return (Criteria) this;
        }

        public Criteria andBenefitEqualTo(Double value) {
            addCriterion("benefit =", value, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitNotEqualTo(Double value) {
            addCriterion("benefit <>", value, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitGreaterThan(Double value) {
            addCriterion("benefit >", value, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitGreaterThanOrEqualTo(Double value) {
            addCriterion("benefit >=", value, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitLessThan(Double value) {
            addCriterion("benefit <", value, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitLessThanOrEqualTo(Double value) {
            addCriterion("benefit <=", value, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitIn(List<Double> values) {
            addCriterion("benefit in", values, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitNotIn(List<Double> values) {
            addCriterion("benefit not in", values, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitBetween(Double value1, Double value2) {
            addCriterion("benefit between", value1, value2, "benefit");
            return (Criteria) this;
        }

        public Criteria andBenefitNotBetween(Double value1, Double value2) {
            addCriterion("benefit not between", value1, value2, "benefit");
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