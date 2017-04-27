package com.bishe.yuanye.dao.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionDTOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuestionDTOExample() {
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

        public Criteria andChapterIsNull() {
            addCriterion("chapterId is null");
            return (Criteria) this;
        }

        public Criteria andChapterIsNotNull() {
            addCriterion("chapterId is not null");
            return (Criteria) this;
        }

        public Criteria andChapterEqualTo(Integer value) {
            addCriterion("chapterId =", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterNotEqualTo(Integer value) {
            addCriterion("chapterId <>", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterGreaterThan(Integer value) {
            addCriterion("chapterId >", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterGreaterThanOrEqualTo(Integer value) {
            addCriterion("chapterId >=", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterLessThan(Integer value) {
            addCriterion("chapterId <", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterLessThanOrEqualTo(Integer value) {
            addCriterion("chapterId <=", value, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterIn(List<Integer> values) {
            addCriterion("chapterId in", values, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterNotIn(List<Integer> values) {
            addCriterion("chapterId not in", values, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterBetween(Integer value1, Integer value2) {
            addCriterion("chapterId between", value1, value2, "chapterId");
            return (Criteria) this;
        }

        public Criteria andChapterNotBetween(Integer value1, Integer value2) {
            addCriterion("chapterId not between", value1, value2, "chapterId");
            return (Criteria) this;
        }

        public Criteria andKeywordOneIsNull() {
            addCriterion("keyword_one is null");
            return (Criteria) this;
        }

        public Criteria andKeywordOneIsNotNull() {
            addCriterion("keyword_one is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordOneEqualTo(String value) {
            addCriterion("keyword_one =", value, "keywordOne");
            return (Criteria) this;
        }

        public Criteria andKeywordOneNotEqualTo(String value) {
            addCriterion("keyword_one <>", value, "keywordOne");
            return (Criteria) this;
        }

        public Criteria andKeywordOneGreaterThan(String value) {
            addCriterion("keyword_one >", value, "keywordOne");
            return (Criteria) this;
        }

        public Criteria andKeywordOneGreaterThanOrEqualTo(String value) {
            addCriterion("keyword_one >=", value, "keywordOne");
            return (Criteria) this;
        }

        public Criteria andKeywordOneLessThan(String value) {
            addCriterion("keyword_one <", value, "keywordOne");
            return (Criteria) this;
        }

        public Criteria andKeywordOneLessThanOrEqualTo(String value) {
            addCriterion("keyword_one <=", value, "keywordOne");
            return (Criteria) this;
        }

        public Criteria andKeywordOneLike(String value) {
            addCriterion("keyword_one like", value, "keywordOne");
            return (Criteria) this;
        }

        public Criteria andKeywordOneNotLike(String value) {
            addCriterion("keyword_one not like", value, "keywordOne");
            return (Criteria) this;
        }

        public Criteria andKeywordOneIn(List<String> values) {
            addCriterion("keyword_one in", values, "keywordOne");
            return (Criteria) this;
        }

        public Criteria andKeywordOneNotIn(List<String> values) {
            addCriterion("keyword_one not in", values, "keywordOne");
            return (Criteria) this;
        }

        public Criteria andKeywordOneBetween(String value1, String value2) {
            addCriterion("keyword_one between", value1, value2, "keywordOne");
            return (Criteria) this;
        }

        public Criteria andKeywordOneNotBetween(String value1, String value2) {
            addCriterion("keyword_one not between", value1, value2, "keywordOne");
            return (Criteria) this;
        }

        public Criteria andKeywordTwoIsNull() {
            addCriterion("keyword_two is null");
            return (Criteria) this;
        }

        public Criteria andKeywordTwoIsNotNull() {
            addCriterion("keyword_two is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordTwoEqualTo(String value) {
            addCriterion("keyword_two =", value, "keywordTwo");
            return (Criteria) this;
        }

        public Criteria andKeywordTwoNotEqualTo(String value) {
            addCriterion("keyword_two <>", value, "keywordTwo");
            return (Criteria) this;
        }

        public Criteria andKeywordTwoGreaterThan(String value) {
            addCriterion("keyword_two >", value, "keywordTwo");
            return (Criteria) this;
        }

        public Criteria andKeywordTwoGreaterThanOrEqualTo(String value) {
            addCriterion("keyword_two >=", value, "keywordTwo");
            return (Criteria) this;
        }

        public Criteria andKeywordTwoLessThan(String value) {
            addCriterion("keyword_two <", value, "keywordTwo");
            return (Criteria) this;
        }

        public Criteria andKeywordTwoLessThanOrEqualTo(String value) {
            addCriterion("keyword_two <=", value, "keywordTwo");
            return (Criteria) this;
        }

        public Criteria andKeywordTwoLike(String value) {
            addCriterion("keyword_two like", value, "keywordTwo");
            return (Criteria) this;
        }

        public Criteria andKeywordTwoNotLike(String value) {
            addCriterion("keyword_two not like", value, "keywordTwo");
            return (Criteria) this;
        }

        public Criteria andKeywordTwoIn(List<String> values) {
            addCriterion("keyword_two in", values, "keywordTwo");
            return (Criteria) this;
        }

        public Criteria andKeywordTwoNotIn(List<String> values) {
            addCriterion("keyword_two not in", values, "keywordTwo");
            return (Criteria) this;
        }

        public Criteria andKeywordTwoBetween(String value1, String value2) {
            addCriterion("keyword_two between", value1, value2, "keywordTwo");
            return (Criteria) this;
        }

        public Criteria andKeywordTwoNotBetween(String value1, String value2) {
            addCriterion("keyword_two not between", value1, value2, "keywordTwo");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andPicOneUrlIsNull() {
            addCriterion("pic_one_url is null");
            return (Criteria) this;
        }

        public Criteria andPicOneUrlIsNotNull() {
            addCriterion("pic_one_url is not null");
            return (Criteria) this;
        }

        public Criteria andPicOneUrlEqualTo(String value) {
            addCriterion("pic_one_url =", value, "picOneUrl");
            return (Criteria) this;
        }

        public Criteria andPicOneUrlNotEqualTo(String value) {
            addCriterion("pic_one_url <>", value, "picOneUrl");
            return (Criteria) this;
        }

        public Criteria andPicOneUrlGreaterThan(String value) {
            addCriterion("pic_one_url >", value, "picOneUrl");
            return (Criteria) this;
        }

        public Criteria andPicOneUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pic_one_url >=", value, "picOneUrl");
            return (Criteria) this;
        }

        public Criteria andPicOneUrlLessThan(String value) {
            addCriterion("pic_one_url <", value, "picOneUrl");
            return (Criteria) this;
        }

        public Criteria andPicOneUrlLessThanOrEqualTo(String value) {
            addCriterion("pic_one_url <=", value, "picOneUrl");
            return (Criteria) this;
        }

        public Criteria andPicOneUrlLike(String value) {
            addCriterion("pic_one_url like", value, "picOneUrl");
            return (Criteria) this;
        }

        public Criteria andPicOneUrlNotLike(String value) {
            addCriterion("pic_one_url not like", value, "picOneUrl");
            return (Criteria) this;
        }

        public Criteria andPicOneUrlIn(List<String> values) {
            addCriterion("pic_one_url in", values, "picOneUrl");
            return (Criteria) this;
        }

        public Criteria andPicOneUrlNotIn(List<String> values) {
            addCriterion("pic_one_url not in", values, "picOneUrl");
            return (Criteria) this;
        }

        public Criteria andPicOneUrlBetween(String value1, String value2) {
            addCriterion("pic_one_url between", value1, value2, "picOneUrl");
            return (Criteria) this;
        }

        public Criteria andPicOneUrlNotBetween(String value1, String value2) {
            addCriterion("pic_one_url not between", value1, value2, "picOneUrl");
            return (Criteria) this;
        }

        public Criteria andPicTwoUrlIsNull() {
            addCriterion("pic_two_url is null");
            return (Criteria) this;
        }

        public Criteria andPicTwoUrlIsNotNull() {
            addCriterion("pic_two_url is not null");
            return (Criteria) this;
        }

        public Criteria andPicTwoUrlEqualTo(String value) {
            addCriterion("pic_two_url =", value, "picTwoUrl");
            return (Criteria) this;
        }

        public Criteria andPicTwoUrlNotEqualTo(String value) {
            addCriterion("pic_two_url <>", value, "picTwoUrl");
            return (Criteria) this;
        }

        public Criteria andPicTwoUrlGreaterThan(String value) {
            addCriterion("pic_two_url >", value, "picTwoUrl");
            return (Criteria) this;
        }

        public Criteria andPicTwoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pic_two_url >=", value, "picTwoUrl");
            return (Criteria) this;
        }

        public Criteria andPicTwoUrlLessThan(String value) {
            addCriterion("pic_two_url <", value, "picTwoUrl");
            return (Criteria) this;
        }

        public Criteria andPicTwoUrlLessThanOrEqualTo(String value) {
            addCriterion("pic_two_url <=", value, "picTwoUrl");
            return (Criteria) this;
        }

        public Criteria andPicTwoUrlLike(String value) {
            addCriterion("pic_two_url like", value, "picTwoUrl");
            return (Criteria) this;
        }

        public Criteria andPicTwoUrlNotLike(String value) {
            addCriterion("pic_two_url not like", value, "picTwoUrl");
            return (Criteria) this;
        }

        public Criteria andPicTwoUrlIn(List<String> values) {
            addCriterion("pic_two_url in", values, "picTwoUrl");
            return (Criteria) this;
        }

        public Criteria andPicTwoUrlNotIn(List<String> values) {
            addCriterion("pic_two_url not in", values, "picTwoUrl");
            return (Criteria) this;
        }

        public Criteria andPicTwoUrlBetween(String value1, String value2) {
            addCriterion("pic_two_url between", value1, value2, "picTwoUrl");
            return (Criteria) this;
        }

        public Criteria andPicTwoUrlNotBetween(String value1, String value2) {
            addCriterion("pic_two_url not between", value1, value2, "picTwoUrl");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
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

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Short value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Short value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Short value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Short value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Short value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Short value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Short> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Short> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Short value1, Short value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Short value1, Short value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
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