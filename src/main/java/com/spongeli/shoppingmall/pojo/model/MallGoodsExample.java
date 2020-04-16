package com.spongeli.shoppingmall.pojo.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MallGoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MallGoodsExample() {
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
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

        public Criteria andCateNameIsNull() {
            addCriterion("cate_name is null");
            return (Criteria) this;
        }

        public Criteria andCateNameIsNotNull() {
            addCriterion("cate_name is not null");
            return (Criteria) this;
        }

        public Criteria andCateNameEqualTo(String value) {
            addCriterion("cate_name =", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameNotEqualTo(String value) {
            addCriterion("cate_name <>", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameGreaterThan(String value) {
            addCriterion("cate_name >", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameGreaterThanOrEqualTo(String value) {
            addCriterion("cate_name >=", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameLessThan(String value) {
            addCriterion("cate_name <", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameLessThanOrEqualTo(String value) {
            addCriterion("cate_name <=", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameLike(String value) {
            addCriterion("cate_name like", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameNotLike(String value) {
            addCriterion("cate_name not like", value, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameIn(List<String> values) {
            addCriterion("cate_name in", values, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameNotIn(List<String> values) {
            addCriterion("cate_name not in", values, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameBetween(String value1, String value2) {
            addCriterion("cate_name between", value1, value2, "cateName");
            return (Criteria) this;
        }

        public Criteria andCateNameNotBetween(String value1, String value2) {
            addCriterion("cate_name not between", value1, value2, "cateName");
            return (Criteria) this;
        }

        public Criteria andGoodsHotsLabelIsNull() {
            addCriterion("goods_hots_label is null");
            return (Criteria) this;
        }

        public Criteria andGoodsHotsLabelIsNotNull() {
            addCriterion("goods_hots_label is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsHotsLabelEqualTo(String value) {
            addCriterion("goods_hots_label =", value, "goodsHotsLabel");
            return (Criteria) this;
        }

        public Criteria andGoodsHotsLabelNotEqualTo(String value) {
            addCriterion("goods_hots_label <>", value, "goodsHotsLabel");
            return (Criteria) this;
        }

        public Criteria andGoodsHotsLabelGreaterThan(String value) {
            addCriterion("goods_hots_label >", value, "goodsHotsLabel");
            return (Criteria) this;
        }

        public Criteria andGoodsHotsLabelGreaterThanOrEqualTo(String value) {
            addCriterion("goods_hots_label >=", value, "goodsHotsLabel");
            return (Criteria) this;
        }

        public Criteria andGoodsHotsLabelLessThan(String value) {
            addCriterion("goods_hots_label <", value, "goodsHotsLabel");
            return (Criteria) this;
        }

        public Criteria andGoodsHotsLabelLessThanOrEqualTo(String value) {
            addCriterion("goods_hots_label <=", value, "goodsHotsLabel");
            return (Criteria) this;
        }

        public Criteria andGoodsHotsLabelLike(String value) {
            addCriterion("goods_hots_label like", value, "goodsHotsLabel");
            return (Criteria) this;
        }

        public Criteria andGoodsHotsLabelNotLike(String value) {
            addCriterion("goods_hots_label not like", value, "goodsHotsLabel");
            return (Criteria) this;
        }

        public Criteria andGoodsHotsLabelIn(List<String> values) {
            addCriterion("goods_hots_label in", values, "goodsHotsLabel");
            return (Criteria) this;
        }

        public Criteria andGoodsHotsLabelNotIn(List<String> values) {
            addCriterion("goods_hots_label not in", values, "goodsHotsLabel");
            return (Criteria) this;
        }

        public Criteria andGoodsHotsLabelBetween(String value1, String value2) {
            addCriterion("goods_hots_label between", value1, value2, "goodsHotsLabel");
            return (Criteria) this;
        }

        public Criteria andGoodsHotsLabelNotBetween(String value1, String value2) {
            addCriterion("goods_hots_label not between", value1, value2, "goodsHotsLabel");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNull() {
            addCriterion("goods_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNotNull() {
            addCriterion("goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceEqualTo(BigDecimal value) {
            addCriterion("goods_price =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotEqualTo(BigDecimal value) {
            addCriterion("goods_price <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThan(BigDecimal value) {
            addCriterion("goods_price >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_price >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThan(BigDecimal value) {
            addCriterion("goods_price <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_price <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIn(List<BigDecimal> values) {
            addCriterion("goods_price in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotIn(List<BigDecimal> values) {
            addCriterion("goods_price not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_price between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_price not between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightIsNull() {
            addCriterion("goods_weight is null");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightIsNotNull() {
            addCriterion("goods_weight is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightEqualTo(Double value) {
            addCriterion("goods_weight =", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightNotEqualTo(Double value) {
            addCriterion("goods_weight <>", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightGreaterThan(Double value) {
            addCriterion("goods_weight >", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("goods_weight >=", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightLessThan(Double value) {
            addCriterion("goods_weight <", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightLessThanOrEqualTo(Double value) {
            addCriterion("goods_weight <=", value, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightIn(List<Double> values) {
            addCriterion("goods_weight in", values, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightNotIn(List<Double> values) {
            addCriterion("goods_weight not in", values, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightBetween(Double value1, Double value2) {
            addCriterion("goods_weight between", value1, value2, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsWeightNotBetween(Double value1, Double value2) {
            addCriterion("goods_weight not between", value1, value2, "goodsWeight");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceIsNull() {
            addCriterion("goods_original_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceIsNotNull() {
            addCriterion("goods_original_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceEqualTo(BigDecimal value) {
            addCriterion("goods_original_price =", value, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceNotEqualTo(BigDecimal value) {
            addCriterion("goods_original_price <>", value, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceGreaterThan(BigDecimal value) {
            addCriterion("goods_original_price >", value, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_original_price >=", value, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceLessThan(BigDecimal value) {
            addCriterion("goods_original_price <", value, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_original_price <=", value, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceIn(List<BigDecimal> values) {
            addCriterion("goods_original_price in", values, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceNotIn(List<BigDecimal> values) {
            addCriterion("goods_original_price not in", values, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_original_price between", value1, value2, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOriginalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_original_price not between", value1, value2, "goodsOriginalPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsHeaderImgIsNull() {
            addCriterion("goods_header_img is null");
            return (Criteria) this;
        }

        public Criteria andGoodsHeaderImgIsNotNull() {
            addCriterion("goods_header_img is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsHeaderImgEqualTo(String value) {
            addCriterion("goods_header_img =", value, "goodsHeaderImg");
            return (Criteria) this;
        }

        public Criteria andGoodsHeaderImgNotEqualTo(String value) {
            addCriterion("goods_header_img <>", value, "goodsHeaderImg");
            return (Criteria) this;
        }

        public Criteria andGoodsHeaderImgGreaterThan(String value) {
            addCriterion("goods_header_img >", value, "goodsHeaderImg");
            return (Criteria) this;
        }

        public Criteria andGoodsHeaderImgGreaterThanOrEqualTo(String value) {
            addCriterion("goods_header_img >=", value, "goodsHeaderImg");
            return (Criteria) this;
        }

        public Criteria andGoodsHeaderImgLessThan(String value) {
            addCriterion("goods_header_img <", value, "goodsHeaderImg");
            return (Criteria) this;
        }

        public Criteria andGoodsHeaderImgLessThanOrEqualTo(String value) {
            addCriterion("goods_header_img <=", value, "goodsHeaderImg");
            return (Criteria) this;
        }

        public Criteria andGoodsHeaderImgLike(String value) {
            addCriterion("goods_header_img like", value, "goodsHeaderImg");
            return (Criteria) this;
        }

        public Criteria andGoodsHeaderImgNotLike(String value) {
            addCriterion("goods_header_img not like", value, "goodsHeaderImg");
            return (Criteria) this;
        }

        public Criteria andGoodsHeaderImgIn(List<String> values) {
            addCriterion("goods_header_img in", values, "goodsHeaderImg");
            return (Criteria) this;
        }

        public Criteria andGoodsHeaderImgNotIn(List<String> values) {
            addCriterion("goods_header_img not in", values, "goodsHeaderImg");
            return (Criteria) this;
        }

        public Criteria andGoodsHeaderImgBetween(String value1, String value2) {
            addCriterion("goods_header_img between", value1, value2, "goodsHeaderImg");
            return (Criteria) this;
        }

        public Criteria andGoodsHeaderImgNotBetween(String value1, String value2) {
            addCriterion("goods_header_img not between", value1, value2, "goodsHeaderImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailIsNull() {
            addCriterion("goods_detail is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailIsNotNull() {
            addCriterion("goods_detail is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailEqualTo(String value) {
            addCriterion("goods_detail =", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNotEqualTo(String value) {
            addCriterion("goods_detail <>", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailGreaterThan(String value) {
            addCriterion("goods_detail >", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailGreaterThanOrEqualTo(String value) {
            addCriterion("goods_detail >=", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailLessThan(String value) {
            addCriterion("goods_detail <", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailLessThanOrEqualTo(String value) {
            addCriterion("goods_detail <=", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailLike(String value) {
            addCriterion("goods_detail like", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNotLike(String value) {
            addCriterion("goods_detail not like", value, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailIn(List<String> values) {
            addCriterion("goods_detail in", values, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNotIn(List<String> values) {
            addCriterion("goods_detail not in", values, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailBetween(String value1, String value2) {
            addCriterion("goods_detail between", value1, value2, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailNotBetween(String value1, String value2) {
            addCriterion("goods_detail not between", value1, value2, "goodsDetail");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIsNull() {
            addCriterion("goods_count is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIsNotNull() {
            addCriterion("goods_count is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCountEqualTo(Integer value) {
            addCriterion("goods_count =", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotEqualTo(Integer value) {
            addCriterion("goods_count <>", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountGreaterThan(Integer value) {
            addCriterion("goods_count >", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_count >=", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountLessThan(Integer value) {
            addCriterion("goods_count <", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountLessThanOrEqualTo(Integer value) {
            addCriterion("goods_count <=", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIn(List<Integer> values) {
            addCriterion("goods_count in", values, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotIn(List<Integer> values) {
            addCriterion("goods_count not in", values, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountBetween(Integer value1, Integer value2) {
            addCriterion("goods_count between", value1, value2, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_count not between", value1, value2, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andScanCountIsNull() {
            addCriterion("scan_count is null");
            return (Criteria) this;
        }

        public Criteria andScanCountIsNotNull() {
            addCriterion("scan_count is not null");
            return (Criteria) this;
        }

        public Criteria andScanCountEqualTo(Integer value) {
            addCriterion("scan_count =", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountNotEqualTo(Integer value) {
            addCriterion("scan_count <>", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountGreaterThan(Integer value) {
            addCriterion("scan_count >", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("scan_count >=", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountLessThan(Integer value) {
            addCriterion("scan_count <", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountLessThanOrEqualTo(Integer value) {
            addCriterion("scan_count <=", value, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountIn(List<Integer> values) {
            addCriterion("scan_count in", values, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountNotIn(List<Integer> values) {
            addCriterion("scan_count not in", values, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountBetween(Integer value1, Integer value2) {
            addCriterion("scan_count between", value1, value2, "scanCount");
            return (Criteria) this;
        }

        public Criteria andScanCountNotBetween(Integer value1, Integer value2) {
            addCriterion("scan_count not between", value1, value2, "scanCount");
            return (Criteria) this;
        }

        public Criteria andSalesCountIsNull() {
            addCriterion("sales_count is null");
            return (Criteria) this;
        }

        public Criteria andSalesCountIsNotNull() {
            addCriterion("sales_count is not null");
            return (Criteria) this;
        }

        public Criteria andSalesCountEqualTo(Integer value) {
            addCriterion("sales_count =", value, "salesCount");
            return (Criteria) this;
        }

        public Criteria andSalesCountNotEqualTo(Integer value) {
            addCriterion("sales_count <>", value, "salesCount");
            return (Criteria) this;
        }

        public Criteria andSalesCountGreaterThan(Integer value) {
            addCriterion("sales_count >", value, "salesCount");
            return (Criteria) this;
        }

        public Criteria andSalesCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sales_count >=", value, "salesCount");
            return (Criteria) this;
        }

        public Criteria andSalesCountLessThan(Integer value) {
            addCriterion("sales_count <", value, "salesCount");
            return (Criteria) this;
        }

        public Criteria andSalesCountLessThanOrEqualTo(Integer value) {
            addCriterion("sales_count <=", value, "salesCount");
            return (Criteria) this;
        }

        public Criteria andSalesCountIn(List<Integer> values) {
            addCriterion("sales_count in", values, "salesCount");
            return (Criteria) this;
        }

        public Criteria andSalesCountNotIn(List<Integer> values) {
            addCriterion("sales_count not in", values, "salesCount");
            return (Criteria) this;
        }

        public Criteria andSalesCountBetween(Integer value1, Integer value2) {
            addCriterion("sales_count between", value1, value2, "salesCount");
            return (Criteria) this;
        }

        public Criteria andSalesCountNotBetween(Integer value1, Integer value2) {
            addCriterion("sales_count not between", value1, value2, "salesCount");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusIsNull() {
            addCriterion("goods_status is null");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusIsNotNull() {
            addCriterion("goods_status is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusEqualTo(Byte value) {
            addCriterion("goods_status =", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusNotEqualTo(Byte value) {
            addCriterion("goods_status <>", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusGreaterThan(Byte value) {
            addCriterion("goods_status >", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("goods_status >=", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusLessThan(Byte value) {
            addCriterion("goods_status <", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusLessThanOrEqualTo(Byte value) {
            addCriterion("goods_status <=", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusIn(List<Byte> values) {
            addCriterion("goods_status in", values, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusNotIn(List<Byte> values) {
            addCriterion("goods_status not in", values, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusBetween(Byte value1, Byte value2) {
            addCriterion("goods_status between", value1, value2, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("goods_status not between", value1, value2, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andDynamicParamIsNull() {
            addCriterion("dynamic_param is null");
            return (Criteria) this;
        }

        public Criteria andDynamicParamIsNotNull() {
            addCriterion("dynamic_param is not null");
            return (Criteria) this;
        }

        public Criteria andDynamicParamEqualTo(String value) {
            addCriterion("dynamic_param =", value, "dynamicParam");
            return (Criteria) this;
        }

        public Criteria andDynamicParamNotEqualTo(String value) {
            addCriterion("dynamic_param <>", value, "dynamicParam");
            return (Criteria) this;
        }

        public Criteria andDynamicParamGreaterThan(String value) {
            addCriterion("dynamic_param >", value, "dynamicParam");
            return (Criteria) this;
        }

        public Criteria andDynamicParamGreaterThanOrEqualTo(String value) {
            addCriterion("dynamic_param >=", value, "dynamicParam");
            return (Criteria) this;
        }

        public Criteria andDynamicParamLessThan(String value) {
            addCriterion("dynamic_param <", value, "dynamicParam");
            return (Criteria) this;
        }

        public Criteria andDynamicParamLessThanOrEqualTo(String value) {
            addCriterion("dynamic_param <=", value, "dynamicParam");
            return (Criteria) this;
        }

        public Criteria andDynamicParamLike(String value) {
            addCriterion("dynamic_param like", value, "dynamicParam");
            return (Criteria) this;
        }

        public Criteria andDynamicParamNotLike(String value) {
            addCriterion("dynamic_param not like", value, "dynamicParam");
            return (Criteria) this;
        }

        public Criteria andDynamicParamIn(List<String> values) {
            addCriterion("dynamic_param in", values, "dynamicParam");
            return (Criteria) this;
        }

        public Criteria andDynamicParamNotIn(List<String> values) {
            addCriterion("dynamic_param not in", values, "dynamicParam");
            return (Criteria) this;
        }

        public Criteria andDynamicParamBetween(String value1, String value2) {
            addCriterion("dynamic_param between", value1, value2, "dynamicParam");
            return (Criteria) this;
        }

        public Criteria andDynamicParamNotBetween(String value1, String value2) {
            addCriterion("dynamic_param not between", value1, value2, "dynamicParam");
            return (Criteria) this;
        }

        public Criteria andServiceParamIsNull() {
            addCriterion("service_param is null");
            return (Criteria) this;
        }

        public Criteria andServiceParamIsNotNull() {
            addCriterion("service_param is not null");
            return (Criteria) this;
        }

        public Criteria andServiceParamEqualTo(String value) {
            addCriterion("service_param =", value, "serviceParam");
            return (Criteria) this;
        }

        public Criteria andServiceParamNotEqualTo(String value) {
            addCriterion("service_param <>", value, "serviceParam");
            return (Criteria) this;
        }

        public Criteria andServiceParamGreaterThan(String value) {
            addCriterion("service_param >", value, "serviceParam");
            return (Criteria) this;
        }

        public Criteria andServiceParamGreaterThanOrEqualTo(String value) {
            addCriterion("service_param >=", value, "serviceParam");
            return (Criteria) this;
        }

        public Criteria andServiceParamLessThan(String value) {
            addCriterion("service_param <", value, "serviceParam");
            return (Criteria) this;
        }

        public Criteria andServiceParamLessThanOrEqualTo(String value) {
            addCriterion("service_param <=", value, "serviceParam");
            return (Criteria) this;
        }

        public Criteria andServiceParamLike(String value) {
            addCriterion("service_param like", value, "serviceParam");
            return (Criteria) this;
        }

        public Criteria andServiceParamNotLike(String value) {
            addCriterion("service_param not like", value, "serviceParam");
            return (Criteria) this;
        }

        public Criteria andServiceParamIn(List<String> values) {
            addCriterion("service_param in", values, "serviceParam");
            return (Criteria) this;
        }

        public Criteria andServiceParamNotIn(List<String> values) {
            addCriterion("service_param not in", values, "serviceParam");
            return (Criteria) this;
        }

        public Criteria andServiceParamBetween(String value1, String value2) {
            addCriterion("service_param between", value1, value2, "serviceParam");
            return (Criteria) this;
        }

        public Criteria andServiceParamNotBetween(String value1, String value2) {
            addCriterion("service_param not between", value1, value2, "serviceParam");
            return (Criteria) this;
        }

        public Criteria andStaticsParamIsNull() {
            addCriterion("statics_param is null");
            return (Criteria) this;
        }

        public Criteria andStaticsParamIsNotNull() {
            addCriterion("statics_param is not null");
            return (Criteria) this;
        }

        public Criteria andStaticsParamEqualTo(String value) {
            addCriterion("statics_param =", value, "staticsParam");
            return (Criteria) this;
        }

        public Criteria andStaticsParamNotEqualTo(String value) {
            addCriterion("statics_param <>", value, "staticsParam");
            return (Criteria) this;
        }

        public Criteria andStaticsParamGreaterThan(String value) {
            addCriterion("statics_param >", value, "staticsParam");
            return (Criteria) this;
        }

        public Criteria andStaticsParamGreaterThanOrEqualTo(String value) {
            addCriterion("statics_param >=", value, "staticsParam");
            return (Criteria) this;
        }

        public Criteria andStaticsParamLessThan(String value) {
            addCriterion("statics_param <", value, "staticsParam");
            return (Criteria) this;
        }

        public Criteria andStaticsParamLessThanOrEqualTo(String value) {
            addCriterion("statics_param <=", value, "staticsParam");
            return (Criteria) this;
        }

        public Criteria andStaticsParamLike(String value) {
            addCriterion("statics_param like", value, "staticsParam");
            return (Criteria) this;
        }

        public Criteria andStaticsParamNotLike(String value) {
            addCriterion("statics_param not like", value, "staticsParam");
            return (Criteria) this;
        }

        public Criteria andStaticsParamIn(List<String> values) {
            addCriterion("statics_param in", values, "staticsParam");
            return (Criteria) this;
        }

        public Criteria andStaticsParamNotIn(List<String> values) {
            addCriterion("statics_param not in", values, "staticsParam");
            return (Criteria) this;
        }

        public Criteria andStaticsParamBetween(String value1, String value2) {
            addCriterion("statics_param between", value1, value2, "staticsParam");
            return (Criteria) this;
        }

        public Criteria andStaticsParamNotBetween(String value1, String value2) {
            addCriterion("statics_param not between", value1, value2, "staticsParam");
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
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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