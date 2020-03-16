package com.example.webchat.entity;

import java.util.ArrayList;
import java.util.List;

public class CouponsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CouponsExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("product_id like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("product_id not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andTradeNameIsNull() {
            addCriterion("trade_name is null");
            return (Criteria) this;
        }

        public Criteria andTradeNameIsNotNull() {
            addCriterion("trade_name is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNameEqualTo(String value) {
            addCriterion("trade_name =", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameNotEqualTo(String value) {
            addCriterion("trade_name <>", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameGreaterThan(String value) {
            addCriterion("trade_name >", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameGreaterThanOrEqualTo(String value) {
            addCriterion("trade_name >=", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameLessThan(String value) {
            addCriterion("trade_name <", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameLessThanOrEqualTo(String value) {
            addCriterion("trade_name <=", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameLike(String value) {
            addCriterion("trade_name like", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameNotLike(String value) {
            addCriterion("trade_name not like", value, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameIn(List<String> values) {
            addCriterion("trade_name in", values, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameNotIn(List<String> values) {
            addCriterion("trade_name not in", values, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameBetween(String value1, String value2) {
            addCriterion("trade_name between", value1, value2, "tradeName");
            return (Criteria) this;
        }

        public Criteria andTradeNameNotBetween(String value1, String value2) {
            addCriterion("trade_name not between", value1, value2, "tradeName");
            return (Criteria) this;
        }

        public Criteria andMainChartOfCommoditiesIsNull() {
            addCriterion("main_chart_of_commodities is null");
            return (Criteria) this;
        }

        public Criteria andMainChartOfCommoditiesIsNotNull() {
            addCriterion("main_chart_of_commodities is not null");
            return (Criteria) this;
        }

        public Criteria andMainChartOfCommoditiesEqualTo(String value) {
            addCriterion("main_chart_of_commodities =", value, "mainChartOfCommodities");
            return (Criteria) this;
        }

        public Criteria andMainChartOfCommoditiesNotEqualTo(String value) {
            addCriterion("main_chart_of_commodities <>", value, "mainChartOfCommodities");
            return (Criteria) this;
        }

        public Criteria andMainChartOfCommoditiesGreaterThan(String value) {
            addCriterion("main_chart_of_commodities >", value, "mainChartOfCommodities");
            return (Criteria) this;
        }

        public Criteria andMainChartOfCommoditiesGreaterThanOrEqualTo(String value) {
            addCriterion("main_chart_of_commodities >=", value, "mainChartOfCommodities");
            return (Criteria) this;
        }

        public Criteria andMainChartOfCommoditiesLessThan(String value) {
            addCriterion("main_chart_of_commodities <", value, "mainChartOfCommodities");
            return (Criteria) this;
        }

        public Criteria andMainChartOfCommoditiesLessThanOrEqualTo(String value) {
            addCriterion("main_chart_of_commodities <=", value, "mainChartOfCommodities");
            return (Criteria) this;
        }

        public Criteria andMainChartOfCommoditiesLike(String value) {
            addCriterion("main_chart_of_commodities like", value, "mainChartOfCommodities");
            return (Criteria) this;
        }

        public Criteria andMainChartOfCommoditiesNotLike(String value) {
            addCriterion("main_chart_of_commodities not like", value, "mainChartOfCommodities");
            return (Criteria) this;
        }

        public Criteria andMainChartOfCommoditiesIn(List<String> values) {
            addCriterion("main_chart_of_commodities in", values, "mainChartOfCommodities");
            return (Criteria) this;
        }

        public Criteria andMainChartOfCommoditiesNotIn(List<String> values) {
            addCriterion("main_chart_of_commodities not in", values, "mainChartOfCommodities");
            return (Criteria) this;
        }

        public Criteria andMainChartOfCommoditiesBetween(String value1, String value2) {
            addCriterion("main_chart_of_commodities between", value1, value2, "mainChartOfCommodities");
            return (Criteria) this;
        }

        public Criteria andMainChartOfCommoditiesNotBetween(String value1, String value2) {
            addCriterion("main_chart_of_commodities not between", value1, value2, "mainChartOfCommodities");
            return (Criteria) this;
        }

        public Criteria andProductInformationPageLinkAddressIsNull() {
            addCriterion("product_information_page_link_address is null");
            return (Criteria) this;
        }

        public Criteria andProductInformationPageLinkAddressIsNotNull() {
            addCriterion("product_information_page_link_address is not null");
            return (Criteria) this;
        }

        public Criteria andProductInformationPageLinkAddressEqualTo(String value) {
            addCriterion("product_information_page_link_address =", value, "productInformationPageLinkAddress");
            return (Criteria) this;
        }

        public Criteria andProductInformationPageLinkAddressNotEqualTo(String value) {
            addCriterion("product_information_page_link_address <>", value, "productInformationPageLinkAddress");
            return (Criteria) this;
        }

        public Criteria andProductInformationPageLinkAddressGreaterThan(String value) {
            addCriterion("product_information_page_link_address >", value, "productInformationPageLinkAddress");
            return (Criteria) this;
        }

        public Criteria andProductInformationPageLinkAddressGreaterThanOrEqualTo(String value) {
            addCriterion("product_information_page_link_address >=", value, "productInformationPageLinkAddress");
            return (Criteria) this;
        }

        public Criteria andProductInformationPageLinkAddressLessThan(String value) {
            addCriterion("product_information_page_link_address <", value, "productInformationPageLinkAddress");
            return (Criteria) this;
        }

        public Criteria andProductInformationPageLinkAddressLessThanOrEqualTo(String value) {
            addCriterion("product_information_page_link_address <=", value, "productInformationPageLinkAddress");
            return (Criteria) this;
        }

        public Criteria andProductInformationPageLinkAddressLike(String value) {
            addCriterion("product_information_page_link_address like", value, "productInformationPageLinkAddress");
            return (Criteria) this;
        }

        public Criteria andProductInformationPageLinkAddressNotLike(String value) {
            addCriterion("product_information_page_link_address not like", value, "productInformationPageLinkAddress");
            return (Criteria) this;
        }

        public Criteria andProductInformationPageLinkAddressIn(List<String> values) {
            addCriterion("product_information_page_link_address in", values, "productInformationPageLinkAddress");
            return (Criteria) this;
        }

        public Criteria andProductInformationPageLinkAddressNotIn(List<String> values) {
            addCriterion("product_information_page_link_address not in", values, "productInformationPageLinkAddress");
            return (Criteria) this;
        }

        public Criteria andProductInformationPageLinkAddressBetween(String value1, String value2) {
            addCriterion("product_information_page_link_address between", value1, value2, "productInformationPageLinkAddress");
            return (Criteria) this;
        }

        public Criteria andProductInformationPageLinkAddressNotBetween(String value1, String value2) {
            addCriterion("product_information_page_link_address not between", value1, value2, "productInformationPageLinkAddress");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryIIsNull() {
            addCriterion("commodity_category_i is null");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryIIsNotNull() {
            addCriterion("commodity_category_i is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryIEqualTo(String value) {
            addCriterion("commodity_category_i =", value, "commodityCategoryI");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryINotEqualTo(String value) {
            addCriterion("commodity_category_i <>", value, "commodityCategoryI");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryIGreaterThan(String value) {
            addCriterion("commodity_category_i >", value, "commodityCategoryI");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryIGreaterThanOrEqualTo(String value) {
            addCriterion("commodity_category_i >=", value, "commodityCategoryI");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryILessThan(String value) {
            addCriterion("commodity_category_i <", value, "commodityCategoryI");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryILessThanOrEqualTo(String value) {
            addCriterion("commodity_category_i <=", value, "commodityCategoryI");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryILike(String value) {
            addCriterion("commodity_category_i like", value, "commodityCategoryI");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryINotLike(String value) {
            addCriterion("commodity_category_i not like", value, "commodityCategoryI");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryIIn(List<String> values) {
            addCriterion("commodity_category_i in", values, "commodityCategoryI");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryINotIn(List<String> values) {
            addCriterion("commodity_category_i not in", values, "commodityCategoryI");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryIBetween(String value1, String value2) {
            addCriterion("commodity_category_i between", value1, value2, "commodityCategoryI");
            return (Criteria) this;
        }

        public Criteria andCommodityCategoryINotBetween(String value1, String value2) {
            addCriterion("commodity_category_i not between", value1, value2, "commodityCategoryI");
            return (Criteria) this;
        }

        public Criteria andLinkToTaobaoIsNull() {
            addCriterion("link_to_taobao is null");
            return (Criteria) this;
        }

        public Criteria andLinkToTaobaoIsNotNull() {
            addCriterion("link_to_taobao is not null");
            return (Criteria) this;
        }

        public Criteria andLinkToTaobaoEqualTo(String value) {
            addCriterion("link_to_taobao =", value, "linkToTaobao");
            return (Criteria) this;
        }

        public Criteria andLinkToTaobaoNotEqualTo(String value) {
            addCriterion("link_to_taobao <>", value, "linkToTaobao");
            return (Criteria) this;
        }

        public Criteria andLinkToTaobaoGreaterThan(String value) {
            addCriterion("link_to_taobao >", value, "linkToTaobao");
            return (Criteria) this;
        }

        public Criteria andLinkToTaobaoGreaterThanOrEqualTo(String value) {
            addCriterion("link_to_taobao >=", value, "linkToTaobao");
            return (Criteria) this;
        }

        public Criteria andLinkToTaobaoLessThan(String value) {
            addCriterion("link_to_taobao <", value, "linkToTaobao");
            return (Criteria) this;
        }

        public Criteria andLinkToTaobaoLessThanOrEqualTo(String value) {
            addCriterion("link_to_taobao <=", value, "linkToTaobao");
            return (Criteria) this;
        }

        public Criteria andLinkToTaobaoLike(String value) {
            addCriterion("link_to_taobao like", value, "linkToTaobao");
            return (Criteria) this;
        }

        public Criteria andLinkToTaobaoNotLike(String value) {
            addCriterion("link_to_taobao not like", value, "linkToTaobao");
            return (Criteria) this;
        }

        public Criteria andLinkToTaobaoIn(List<String> values) {
            addCriterion("link_to_taobao in", values, "linkToTaobao");
            return (Criteria) this;
        }

        public Criteria andLinkToTaobaoNotIn(List<String> values) {
            addCriterion("link_to_taobao not in", values, "linkToTaobao");
            return (Criteria) this;
        }

        public Criteria andLinkToTaobaoBetween(String value1, String value2) {
            addCriterion("link_to_taobao between", value1, value2, "linkToTaobao");
            return (Criteria) this;
        }

        public Criteria andLinkToTaobaoNotBetween(String value1, String value2) {
            addCriterion("link_to_taobao not between", value1, value2, "linkToTaobao");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceIsNull() {
            addCriterion("commodity_price is null");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceIsNotNull() {
            addCriterion("commodity_price is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceEqualTo(String value) {
            addCriterion("commodity_price =", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceNotEqualTo(String value) {
            addCriterion("commodity_price <>", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceGreaterThan(String value) {
            addCriterion("commodity_price >", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceGreaterThanOrEqualTo(String value) {
            addCriterion("commodity_price >=", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceLessThan(String value) {
            addCriterion("commodity_price <", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceLessThanOrEqualTo(String value) {
            addCriterion("commodity_price <=", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceLike(String value) {
            addCriterion("commodity_price like", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceNotLike(String value) {
            addCriterion("commodity_price not like", value, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceIn(List<String> values) {
            addCriterion("commodity_price in", values, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceNotIn(List<String> values) {
            addCriterion("commodity_price not in", values, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceBetween(String value1, String value2) {
            addCriterion("commodity_price between", value1, value2, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andCommodityPriceNotBetween(String value1, String value2) {
            addCriterion("commodity_price not between", value1, value2, "commodityPrice");
            return (Criteria) this;
        }

        public Criteria andMonthlyMerchandiseSalesIsNull() {
            addCriterion("monthly_merchandise_sales is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyMerchandiseSalesIsNotNull() {
            addCriterion("monthly_merchandise_sales is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyMerchandiseSalesEqualTo(String value) {
            addCriterion("monthly_merchandise_sales =", value, "monthlyMerchandiseSales");
            return (Criteria) this;
        }

        public Criteria andMonthlyMerchandiseSalesNotEqualTo(String value) {
            addCriterion("monthly_merchandise_sales <>", value, "monthlyMerchandiseSales");
            return (Criteria) this;
        }

        public Criteria andMonthlyMerchandiseSalesGreaterThan(String value) {
            addCriterion("monthly_merchandise_sales >", value, "monthlyMerchandiseSales");
            return (Criteria) this;
        }

        public Criteria andMonthlyMerchandiseSalesGreaterThanOrEqualTo(String value) {
            addCriterion("monthly_merchandise_sales >=", value, "monthlyMerchandiseSales");
            return (Criteria) this;
        }

        public Criteria andMonthlyMerchandiseSalesLessThan(String value) {
            addCriterion("monthly_merchandise_sales <", value, "monthlyMerchandiseSales");
            return (Criteria) this;
        }

        public Criteria andMonthlyMerchandiseSalesLessThanOrEqualTo(String value) {
            addCriterion("monthly_merchandise_sales <=", value, "monthlyMerchandiseSales");
            return (Criteria) this;
        }

        public Criteria andMonthlyMerchandiseSalesLike(String value) {
            addCriterion("monthly_merchandise_sales like", value, "monthlyMerchandiseSales");
            return (Criteria) this;
        }

        public Criteria andMonthlyMerchandiseSalesNotLike(String value) {
            addCriterion("monthly_merchandise_sales not like", value, "monthlyMerchandiseSales");
            return (Criteria) this;
        }

        public Criteria andMonthlyMerchandiseSalesIn(List<String> values) {
            addCriterion("monthly_merchandise_sales in", values, "monthlyMerchandiseSales");
            return (Criteria) this;
        }

        public Criteria andMonthlyMerchandiseSalesNotIn(List<String> values) {
            addCriterion("monthly_merchandise_sales not in", values, "monthlyMerchandiseSales");
            return (Criteria) this;
        }

        public Criteria andMonthlyMerchandiseSalesBetween(String value1, String value2) {
            addCriterion("monthly_merchandise_sales between", value1, value2, "monthlyMerchandiseSales");
            return (Criteria) this;
        }

        public Criteria andMonthlyMerchandiseSalesNotBetween(String value1, String value2) {
            addCriterion("monthly_merchandise_sales not between", value1, value2, "monthlyMerchandiseSales");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioIsNull() {
            addCriterion("income_ratio is null");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioIsNotNull() {
            addCriterion("income_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioEqualTo(String value) {
            addCriterion("income_ratio =", value, "incomeRatio");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioNotEqualTo(String value) {
            addCriterion("income_ratio <>", value, "incomeRatio");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioGreaterThan(String value) {
            addCriterion("income_ratio >", value, "incomeRatio");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioGreaterThanOrEqualTo(String value) {
            addCriterion("income_ratio >=", value, "incomeRatio");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioLessThan(String value) {
            addCriterion("income_ratio <", value, "incomeRatio");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioLessThanOrEqualTo(String value) {
            addCriterion("income_ratio <=", value, "incomeRatio");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioLike(String value) {
            addCriterion("income_ratio like", value, "incomeRatio");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioNotLike(String value) {
            addCriterion("income_ratio not like", value, "incomeRatio");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioIn(List<String> values) {
            addCriterion("income_ratio in", values, "incomeRatio");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioNotIn(List<String> values) {
            addCriterion("income_ratio not in", values, "incomeRatio");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioBetween(String value1, String value2) {
            addCriterion("income_ratio between", value1, value2, "incomeRatio");
            return (Criteria) this;
        }

        public Criteria andIncomeRatioNotBetween(String value1, String value2) {
            addCriterion("income_ratio not between", value1, value2, "incomeRatio");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNull() {
            addCriterion("commission is null");
            return (Criteria) this;
        }

        public Criteria andCommissionIsNotNull() {
            addCriterion("commission is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionEqualTo(String value) {
            addCriterion("commission =", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotEqualTo(String value) {
            addCriterion("commission <>", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThan(String value) {
            addCriterion("commission >", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionGreaterThanOrEqualTo(String value) {
            addCriterion("commission >=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThan(String value) {
            addCriterion("commission <", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLessThanOrEqualTo(String value) {
            addCriterion("commission <=", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionLike(String value) {
            addCriterion("commission like", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotLike(String value) {
            addCriterion("commission not like", value, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionIn(List<String> values) {
            addCriterion("commission in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotIn(List<String> values) {
            addCriterion("commission not in", values, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionBetween(String value1, String value2) {
            addCriterion("commission between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andCommissionNotBetween(String value1, String value2) {
            addCriterion("commission not between", value1, value2, "commission");
            return (Criteria) this;
        }

        public Criteria andTheSellerWantWantIsNull() {
            addCriterion("the_seller_want_want is null");
            return (Criteria) this;
        }

        public Criteria andTheSellerWantWantIsNotNull() {
            addCriterion("the_seller_want_want is not null");
            return (Criteria) this;
        }

        public Criteria andTheSellerWantWantEqualTo(String value) {
            addCriterion("the_seller_want_want =", value, "theSellerWantWant");
            return (Criteria) this;
        }

        public Criteria andTheSellerWantWantNotEqualTo(String value) {
            addCriterion("the_seller_want_want <>", value, "theSellerWantWant");
            return (Criteria) this;
        }

        public Criteria andTheSellerWantWantGreaterThan(String value) {
            addCriterion("the_seller_want_want >", value, "theSellerWantWant");
            return (Criteria) this;
        }

        public Criteria andTheSellerWantWantGreaterThanOrEqualTo(String value) {
            addCriterion("the_seller_want_want >=", value, "theSellerWantWant");
            return (Criteria) this;
        }

        public Criteria andTheSellerWantWantLessThan(String value) {
            addCriterion("the_seller_want_want <", value, "theSellerWantWant");
            return (Criteria) this;
        }

        public Criteria andTheSellerWantWantLessThanOrEqualTo(String value) {
            addCriterion("the_seller_want_want <=", value, "theSellerWantWant");
            return (Criteria) this;
        }

        public Criteria andTheSellerWantWantLike(String value) {
            addCriterion("the_seller_want_want like", value, "theSellerWantWant");
            return (Criteria) this;
        }

        public Criteria andTheSellerWantWantNotLike(String value) {
            addCriterion("the_seller_want_want not like", value, "theSellerWantWant");
            return (Criteria) this;
        }

        public Criteria andTheSellerWantWantIn(List<String> values) {
            addCriterion("the_seller_want_want in", values, "theSellerWantWant");
            return (Criteria) this;
        }

        public Criteria andTheSellerWantWantNotIn(List<String> values) {
            addCriterion("the_seller_want_want not in", values, "theSellerWantWant");
            return (Criteria) this;
        }

        public Criteria andTheSellerWantWantBetween(String value1, String value2) {
            addCriterion("the_seller_want_want between", value1, value2, "theSellerWantWant");
            return (Criteria) this;
        }

        public Criteria andTheSellerWantWantNotBetween(String value1, String value2) {
            addCriterion("the_seller_want_want not between", value1, value2, "theSellerWantWant");
            return (Criteria) this;
        }

        public Criteria andSellerIdIsNull() {
            addCriterion("seller_id is null");
            return (Criteria) this;
        }

        public Criteria andSellerIdIsNotNull() {
            addCriterion("seller_id is not null");
            return (Criteria) this;
        }

        public Criteria andSellerIdEqualTo(String value) {
            addCriterion("seller_id =", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotEqualTo(String value) {
            addCriterion("seller_id <>", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThan(String value) {
            addCriterion("seller_id >", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdGreaterThanOrEqualTo(String value) {
            addCriterion("seller_id >=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThan(String value) {
            addCriterion("seller_id <", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLessThanOrEqualTo(String value) {
            addCriterion("seller_id <=", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdLike(String value) {
            addCriterion("seller_id like", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotLike(String value) {
            addCriterion("seller_id not like", value, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdIn(List<String> values) {
            addCriterion("seller_id in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotIn(List<String> values) {
            addCriterion("seller_id not in", values, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdBetween(String value1, String value2) {
            addCriterion("seller_id between", value1, value2, "sellerId");
            return (Criteria) this;
        }

        public Criteria andSellerIdNotBetween(String value1, String value2) {
            addCriterion("seller_id not between", value1, value2, "sellerId");
            return (Criteria) this;
        }

        public Criteria andNameOfShopIsNull() {
            addCriterion("name_of_shop is null");
            return (Criteria) this;
        }

        public Criteria andNameOfShopIsNotNull() {
            addCriterion("name_of_shop is not null");
            return (Criteria) this;
        }

        public Criteria andNameOfShopEqualTo(String value) {
            addCriterion("name_of_shop =", value, "nameOfShop");
            return (Criteria) this;
        }

        public Criteria andNameOfShopNotEqualTo(String value) {
            addCriterion("name_of_shop <>", value, "nameOfShop");
            return (Criteria) this;
        }

        public Criteria andNameOfShopGreaterThan(String value) {
            addCriterion("name_of_shop >", value, "nameOfShop");
            return (Criteria) this;
        }

        public Criteria andNameOfShopGreaterThanOrEqualTo(String value) {
            addCriterion("name_of_shop >=", value, "nameOfShop");
            return (Criteria) this;
        }

        public Criteria andNameOfShopLessThan(String value) {
            addCriterion("name_of_shop <", value, "nameOfShop");
            return (Criteria) this;
        }

        public Criteria andNameOfShopLessThanOrEqualTo(String value) {
            addCriterion("name_of_shop <=", value, "nameOfShop");
            return (Criteria) this;
        }

        public Criteria andNameOfShopLike(String value) {
            addCriterion("name_of_shop like", value, "nameOfShop");
            return (Criteria) this;
        }

        public Criteria andNameOfShopNotLike(String value) {
            addCriterion("name_of_shop not like", value, "nameOfShop");
            return (Criteria) this;
        }

        public Criteria andNameOfShopIn(List<String> values) {
            addCriterion("name_of_shop in", values, "nameOfShop");
            return (Criteria) this;
        }

        public Criteria andNameOfShopNotIn(List<String> values) {
            addCriterion("name_of_shop not in", values, "nameOfShop");
            return (Criteria) this;
        }

        public Criteria andNameOfShopBetween(String value1, String value2) {
            addCriterion("name_of_shop between", value1, value2, "nameOfShop");
            return (Criteria) this;
        }

        public Criteria andNameOfShopNotBetween(String value1, String value2) {
            addCriterion("name_of_shop not between", value1, value2, "nameOfShop");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeIsNull() {
            addCriterion("platform_type is null");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeIsNotNull() {
            addCriterion("platform_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeEqualTo(String value) {
            addCriterion("platform_type =", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeNotEqualTo(String value) {
            addCriterion("platform_type <>", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeGreaterThan(String value) {
            addCriterion("platform_type >", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeGreaterThanOrEqualTo(String value) {
            addCriterion("platform_type >=", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeLessThan(String value) {
            addCriterion("platform_type <", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeLessThanOrEqualTo(String value) {
            addCriterion("platform_type <=", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeLike(String value) {
            addCriterion("platform_type like", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeNotLike(String value) {
            addCriterion("platform_type not like", value, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeIn(List<String> values) {
            addCriterion("platform_type in", values, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeNotIn(List<String> values) {
            addCriterion("platform_type not in", values, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeBetween(String value1, String value2) {
            addCriterion("platform_type between", value1, value2, "platformType");
            return (Criteria) this;
        }

        public Criteria andPlatformTypeNotBetween(String value1, String value2) {
            addCriterion("platform_type not between", value1, value2, "platformType");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNull() {
            addCriterion("coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNotNull() {
            addCriterion("coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andCouponIdEqualTo(String value) {
            addCriterion("coupon_id =", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotEqualTo(String value) {
            addCriterion("coupon_id <>", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThan(String value) {
            addCriterion("coupon_id >", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_id >=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThan(String value) {
            addCriterion("coupon_id <", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThanOrEqualTo(String value) {
            addCriterion("coupon_id <=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLike(String value) {
            addCriterion("coupon_id like", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotLike(String value) {
            addCriterion("coupon_id not like", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdIn(List<String> values) {
            addCriterion("coupon_id in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotIn(List<String> values) {
            addCriterion("coupon_id not in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdBetween(String value1, String value2) {
            addCriterion("coupon_id between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotBetween(String value1, String value2) {
            addCriterion("coupon_id not between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andTotalCouponsIsNull() {
            addCriterion("total_coupons is null");
            return (Criteria) this;
        }

        public Criteria andTotalCouponsIsNotNull() {
            addCriterion("total_coupons is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCouponsEqualTo(String value) {
            addCriterion("total_coupons =", value, "totalCoupons");
            return (Criteria) this;
        }

        public Criteria andTotalCouponsNotEqualTo(String value) {
            addCriterion("total_coupons <>", value, "totalCoupons");
            return (Criteria) this;
        }

        public Criteria andTotalCouponsGreaterThan(String value) {
            addCriterion("total_coupons >", value, "totalCoupons");
            return (Criteria) this;
        }

        public Criteria andTotalCouponsGreaterThanOrEqualTo(String value) {
            addCriterion("total_coupons >=", value, "totalCoupons");
            return (Criteria) this;
        }

        public Criteria andTotalCouponsLessThan(String value) {
            addCriterion("total_coupons <", value, "totalCoupons");
            return (Criteria) this;
        }

        public Criteria andTotalCouponsLessThanOrEqualTo(String value) {
            addCriterion("total_coupons <=", value, "totalCoupons");
            return (Criteria) this;
        }

        public Criteria andTotalCouponsLike(String value) {
            addCriterion("total_coupons like", value, "totalCoupons");
            return (Criteria) this;
        }

        public Criteria andTotalCouponsNotLike(String value) {
            addCriterion("total_coupons not like", value, "totalCoupons");
            return (Criteria) this;
        }

        public Criteria andTotalCouponsIn(List<String> values) {
            addCriterion("total_coupons in", values, "totalCoupons");
            return (Criteria) this;
        }

        public Criteria andTotalCouponsNotIn(List<String> values) {
            addCriterion("total_coupons not in", values, "totalCoupons");
            return (Criteria) this;
        }

        public Criteria andTotalCouponsBetween(String value1, String value2) {
            addCriterion("total_coupons between", value1, value2, "totalCoupons");
            return (Criteria) this;
        }

        public Criteria andTotalCouponsNotBetween(String value1, String value2) {
            addCriterion("total_coupons not between", value1, value2, "totalCoupons");
            return (Criteria) this;
        }

        public Criteria andCouponSurplusIsNull() {
            addCriterion("coupon_surplus is null");
            return (Criteria) this;
        }

        public Criteria andCouponSurplusIsNotNull() {
            addCriterion("coupon_surplus is not null");
            return (Criteria) this;
        }

        public Criteria andCouponSurplusEqualTo(String value) {
            addCriterion("coupon_surplus =", value, "couponSurplus");
            return (Criteria) this;
        }

        public Criteria andCouponSurplusNotEqualTo(String value) {
            addCriterion("coupon_surplus <>", value, "couponSurplus");
            return (Criteria) this;
        }

        public Criteria andCouponSurplusGreaterThan(String value) {
            addCriterion("coupon_surplus >", value, "couponSurplus");
            return (Criteria) this;
        }

        public Criteria andCouponSurplusGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_surplus >=", value, "couponSurplus");
            return (Criteria) this;
        }

        public Criteria andCouponSurplusLessThan(String value) {
            addCriterion("coupon_surplus <", value, "couponSurplus");
            return (Criteria) this;
        }

        public Criteria andCouponSurplusLessThanOrEqualTo(String value) {
            addCriterion("coupon_surplus <=", value, "couponSurplus");
            return (Criteria) this;
        }

        public Criteria andCouponSurplusLike(String value) {
            addCriterion("coupon_surplus like", value, "couponSurplus");
            return (Criteria) this;
        }

        public Criteria andCouponSurplusNotLike(String value) {
            addCriterion("coupon_surplus not like", value, "couponSurplus");
            return (Criteria) this;
        }

        public Criteria andCouponSurplusIn(List<String> values) {
            addCriterion("coupon_surplus in", values, "couponSurplus");
            return (Criteria) this;
        }

        public Criteria andCouponSurplusNotIn(List<String> values) {
            addCriterion("coupon_surplus not in", values, "couponSurplus");
            return (Criteria) this;
        }

        public Criteria andCouponSurplusBetween(String value1, String value2) {
            addCriterion("coupon_surplus between", value1, value2, "couponSurplus");
            return (Criteria) this;
        }

        public Criteria andCouponSurplusNotBetween(String value1, String value2) {
            addCriterion("coupon_surplus not between", value1, value2, "couponSurplus");
            return (Criteria) this;
        }

        public Criteria andCouponValueIsNull() {
            addCriterion("coupon_value is null");
            return (Criteria) this;
        }

        public Criteria andCouponValueIsNotNull() {
            addCriterion("coupon_value is not null");
            return (Criteria) this;
        }

        public Criteria andCouponValueEqualTo(String value) {
            addCriterion("coupon_value =", value, "couponValue");
            return (Criteria) this;
        }

        public Criteria andCouponValueNotEqualTo(String value) {
            addCriterion("coupon_value <>", value, "couponValue");
            return (Criteria) this;
        }

        public Criteria andCouponValueGreaterThan(String value) {
            addCriterion("coupon_value >", value, "couponValue");
            return (Criteria) this;
        }

        public Criteria andCouponValueGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_value >=", value, "couponValue");
            return (Criteria) this;
        }

        public Criteria andCouponValueLessThan(String value) {
            addCriterion("coupon_value <", value, "couponValue");
            return (Criteria) this;
        }

        public Criteria andCouponValueLessThanOrEqualTo(String value) {
            addCriterion("coupon_value <=", value, "couponValue");
            return (Criteria) this;
        }

        public Criteria andCouponValueLike(String value) {
            addCriterion("coupon_value like", value, "couponValue");
            return (Criteria) this;
        }

        public Criteria andCouponValueNotLike(String value) {
            addCriterion("coupon_value not like", value, "couponValue");
            return (Criteria) this;
        }

        public Criteria andCouponValueIn(List<String> values) {
            addCriterion("coupon_value in", values, "couponValue");
            return (Criteria) this;
        }

        public Criteria andCouponValueNotIn(List<String> values) {
            addCriterion("coupon_value not in", values, "couponValue");
            return (Criteria) this;
        }

        public Criteria andCouponValueBetween(String value1, String value2) {
            addCriterion("coupon_value between", value1, value2, "couponValue");
            return (Criteria) this;
        }

        public Criteria andCouponValueNotBetween(String value1, String value2) {
            addCriterion("coupon_value not between", value1, value2, "couponValue");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeIsNull() {
            addCriterion("coupon_start_time is null");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeIsNotNull() {
            addCriterion("coupon_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeEqualTo(String value) {
            addCriterion("coupon_start_time =", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeNotEqualTo(String value) {
            addCriterion("coupon_start_time <>", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeGreaterThan(String value) {
            addCriterion("coupon_start_time >", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_start_time >=", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeLessThan(String value) {
            addCriterion("coupon_start_time <", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeLessThanOrEqualTo(String value) {
            addCriterion("coupon_start_time <=", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeLike(String value) {
            addCriterion("coupon_start_time like", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeNotLike(String value) {
            addCriterion("coupon_start_time not like", value, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeIn(List<String> values) {
            addCriterion("coupon_start_time in", values, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeNotIn(List<String> values) {
            addCriterion("coupon_start_time not in", values, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeBetween(String value1, String value2) {
            addCriterion("coupon_start_time between", value1, value2, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponStartTimeNotBetween(String value1, String value2) {
            addCriterion("coupon_start_time not between", value1, value2, "couponStartTime");
            return (Criteria) this;
        }

        public Criteria andCouponClosingTimeIsNull() {
            addCriterion("coupon_closing_time is null");
            return (Criteria) this;
        }

        public Criteria andCouponClosingTimeIsNotNull() {
            addCriterion("coupon_closing_time is not null");
            return (Criteria) this;
        }

        public Criteria andCouponClosingTimeEqualTo(String value) {
            addCriterion("coupon_closing_time =", value, "couponClosingTime");
            return (Criteria) this;
        }

        public Criteria andCouponClosingTimeNotEqualTo(String value) {
            addCriterion("coupon_closing_time <>", value, "couponClosingTime");
            return (Criteria) this;
        }

        public Criteria andCouponClosingTimeGreaterThan(String value) {
            addCriterion("coupon_closing_time >", value, "couponClosingTime");
            return (Criteria) this;
        }

        public Criteria andCouponClosingTimeGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_closing_time >=", value, "couponClosingTime");
            return (Criteria) this;
        }

        public Criteria andCouponClosingTimeLessThan(String value) {
            addCriterion("coupon_closing_time <", value, "couponClosingTime");
            return (Criteria) this;
        }

        public Criteria andCouponClosingTimeLessThanOrEqualTo(String value) {
            addCriterion("coupon_closing_time <=", value, "couponClosingTime");
            return (Criteria) this;
        }

        public Criteria andCouponClosingTimeLike(String value) {
            addCriterion("coupon_closing_time like", value, "couponClosingTime");
            return (Criteria) this;
        }

        public Criteria andCouponClosingTimeNotLike(String value) {
            addCriterion("coupon_closing_time not like", value, "couponClosingTime");
            return (Criteria) this;
        }

        public Criteria andCouponClosingTimeIn(List<String> values) {
            addCriterion("coupon_closing_time in", values, "couponClosingTime");
            return (Criteria) this;
        }

        public Criteria andCouponClosingTimeNotIn(List<String> values) {
            addCriterion("coupon_closing_time not in", values, "couponClosingTime");
            return (Criteria) this;
        }

        public Criteria andCouponClosingTimeBetween(String value1, String value2) {
            addCriterion("coupon_closing_time between", value1, value2, "couponClosingTime");
            return (Criteria) this;
        }

        public Criteria andCouponClosingTimeNotBetween(String value1, String value2) {
            addCriterion("coupon_closing_time not between", value1, value2, "couponClosingTime");
            return (Criteria) this;
        }

        public Criteria andCouponLinkIsNull() {
            addCriterion("coupon_link is null");
            return (Criteria) this;
        }

        public Criteria andCouponLinkIsNotNull() {
            addCriterion("coupon_link is not null");
            return (Criteria) this;
        }

        public Criteria andCouponLinkEqualTo(String value) {
            addCriterion("coupon_link =", value, "couponLink");
            return (Criteria) this;
        }

        public Criteria andCouponLinkNotEqualTo(String value) {
            addCriterion("coupon_link <>", value, "couponLink");
            return (Criteria) this;
        }

        public Criteria andCouponLinkGreaterThan(String value) {
            addCriterion("coupon_link >", value, "couponLink");
            return (Criteria) this;
        }

        public Criteria andCouponLinkGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_link >=", value, "couponLink");
            return (Criteria) this;
        }

        public Criteria andCouponLinkLessThan(String value) {
            addCriterion("coupon_link <", value, "couponLink");
            return (Criteria) this;
        }

        public Criteria andCouponLinkLessThanOrEqualTo(String value) {
            addCriterion("coupon_link <=", value, "couponLink");
            return (Criteria) this;
        }

        public Criteria andCouponLinkLike(String value) {
            addCriterion("coupon_link like", value, "couponLink");
            return (Criteria) this;
        }

        public Criteria andCouponLinkNotLike(String value) {
            addCriterion("coupon_link not like", value, "couponLink");
            return (Criteria) this;
        }

        public Criteria andCouponLinkIn(List<String> values) {
            addCriterion("coupon_link in", values, "couponLink");
            return (Criteria) this;
        }

        public Criteria andCouponLinkNotIn(List<String> values) {
            addCriterion("coupon_link not in", values, "couponLink");
            return (Criteria) this;
        }

        public Criteria andCouponLinkBetween(String value1, String value2) {
            addCriterion("coupon_link between", value1, value2, "couponLink");
            return (Criteria) this;
        }

        public Criteria andCouponLinkNotBetween(String value1, String value2) {
            addCriterion("coupon_link not between", value1, value2, "couponLink");
            return (Criteria) this;
        }

        public Criteria andProductCouponPromotionLinkIsNull() {
            addCriterion("product_coupon_promotion_link is null");
            return (Criteria) this;
        }

        public Criteria andProductCouponPromotionLinkIsNotNull() {
            addCriterion("product_coupon_promotion_link is not null");
            return (Criteria) this;
        }

        public Criteria andProductCouponPromotionLinkEqualTo(String value) {
            addCriterion("product_coupon_promotion_link =", value, "productCouponPromotionLink");
            return (Criteria) this;
        }

        public Criteria andProductCouponPromotionLinkNotEqualTo(String value) {
            addCriterion("product_coupon_promotion_link <>", value, "productCouponPromotionLink");
            return (Criteria) this;
        }

        public Criteria andProductCouponPromotionLinkGreaterThan(String value) {
            addCriterion("product_coupon_promotion_link >", value, "productCouponPromotionLink");
            return (Criteria) this;
        }

        public Criteria andProductCouponPromotionLinkGreaterThanOrEqualTo(String value) {
            addCriterion("product_coupon_promotion_link >=", value, "productCouponPromotionLink");
            return (Criteria) this;
        }

        public Criteria andProductCouponPromotionLinkLessThan(String value) {
            addCriterion("product_coupon_promotion_link <", value, "productCouponPromotionLink");
            return (Criteria) this;
        }

        public Criteria andProductCouponPromotionLinkLessThanOrEqualTo(String value) {
            addCriterion("product_coupon_promotion_link <=", value, "productCouponPromotionLink");
            return (Criteria) this;
        }

        public Criteria andProductCouponPromotionLinkLike(String value) {
            addCriterion("product_coupon_promotion_link like", value, "productCouponPromotionLink");
            return (Criteria) this;
        }

        public Criteria andProductCouponPromotionLinkNotLike(String value) {
            addCriterion("product_coupon_promotion_link not like", value, "productCouponPromotionLink");
            return (Criteria) this;
        }

        public Criteria andProductCouponPromotionLinkIn(List<String> values) {
            addCriterion("product_coupon_promotion_link in", values, "productCouponPromotionLink");
            return (Criteria) this;
        }

        public Criteria andProductCouponPromotionLinkNotIn(List<String> values) {
            addCriterion("product_coupon_promotion_link not in", values, "productCouponPromotionLink");
            return (Criteria) this;
        }

        public Criteria andProductCouponPromotionLinkBetween(String value1, String value2) {
            addCriterion("product_coupon_promotion_link between", value1, value2, "productCouponPromotionLink");
            return (Criteria) this;
        }

        public Criteria andProductCouponPromotionLinkNotBetween(String value1, String value2) {
            addCriterion("product_coupon_promotion_link not between", value1, value2, "productCouponPromotionLink");
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