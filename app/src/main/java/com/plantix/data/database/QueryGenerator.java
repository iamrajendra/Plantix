package com.plantix.data.database;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SimpleSQLiteQuery;

import java.util.HashMap;
import java.util.Iterator;


public class QueryGenerator {
    private StringBuilder stringBuilder;

    public QueryGenerator() {
        stringBuilder = new StringBuilder();
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public QueryGenerator select() {
        stringBuilder.append("SELECT");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator delete() {
        stringBuilder.append("DELETE");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator update(Class value) {
        stringBuilder.append("UPDATE");
        stringBuilder.append(" ");
        stringBuilder.append(value.getSimpleName());
        stringBuilder.append(" ");
        stringBuilder.append("SET");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator extras(Object s) {
        stringBuilder.append(" ");
        stringBuilder.append(s);
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator all() {
        stringBuilder.append("*");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator join(Class... tables) {

        for (Class table : tables) {
            stringBuilder.append(table.getSimpleName());
            stringBuilder.append(".");
            stringBuilder.append("*");
            stringBuilder.append(",");
            stringBuilder.append(" ");
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append(" ");
        stringBuilder.append("FROM");
        stringBuilder.append(" ");
        for (Class table : tables) {
            stringBuilder.append(table.getSimpleName());
            stringBuilder.append(",");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator joinRelation(String s) {
        stringBuilder.append(s);
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator whereJoinRelation(String s) {
        stringBuilder.append("WHERE");
        stringBuilder.append(" ");
        stringBuilder.append(s);
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator count(String column) {
        stringBuilder.append("COUNT");
        stringBuilder.append("(");
        stringBuilder.append(column);
        stringBuilder.append(")");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator groutConcat(String column) {
        stringBuilder.append("GROUP_CONCAT");
        stringBuilder.append("(");
        stringBuilder.append(column);
        stringBuilder.append(")");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator asChangeName(String column) {
        stringBuilder.append("as");
        stringBuilder.append(" ");
        stringBuilder.append(column);
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator comma() {
        stringBuilder.append(",");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator sum(String column) {
        stringBuilder.append("SUM");
        stringBuilder.append("(");
        stringBuilder.append(column);
        stringBuilder.append(")");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator selectVariable(String value) {
        stringBuilder.append(value);
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator max(String value) {
        stringBuilder.append("MAX");
        stringBuilder.append("(");
        stringBuilder.append(value);
        stringBuilder.append(")");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator min(String value) {
        stringBuilder.append("MIN");
        stringBuilder.append("(");
        stringBuilder.append(value);
        stringBuilder.append(")");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator selectVariable(String... value) {
        String s = TextUtils.join(",", value);
        stringBuilder.append(s);
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator from(String value) {
        stringBuilder.append("FROM");
        stringBuilder.append(" ");
        stringBuilder.append(value);
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator from() {
        stringBuilder.append("FROM");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator on() {
        stringBuilder.append("ON");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator leftOuterJoin(Class value) {
        stringBuilder.append("LEFT OUTER JOIN");
        stringBuilder.append(" ");
        stringBuilder.append(value.getSimpleName());
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator leftJoin(Class value) {
        stringBuilder.append("LEFT JOIN");
        stringBuilder.append(" ");
        stringBuilder.append(value.getSimpleName());
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator from(Class value) {
        stringBuilder.append("FROM");
        stringBuilder.append(" ");
        stringBuilder.append(value.getSimpleName());
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator and() {
        stringBuilder.append(" ");
        stringBuilder.append("AND");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator roundParenthesesOpen() {
        stringBuilder.append(" ");
        stringBuilder.append("(");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator cases() {
        stringBuilder.append("CASE");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator end() {
        stringBuilder.append("END");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator when() {
        stringBuilder.append("WHEN");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator elses(int i) {
        stringBuilder.append("ELSE");
        stringBuilder.append(" ");
        stringBuilder.append(i);
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator then(int i) {
        stringBuilder.append("THEN");
        stringBuilder.append(" ");
        stringBuilder.append(i);
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator roundParenthesesClose() {
        stringBuilder.append(" ");
        stringBuilder.append(")");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator or() {
        stringBuilder.append(" ");
        stringBuilder.append("OR");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator whereClause(HashMap<String, Object> value) {
        stringBuilder.append("WHERE");
        stringBuilder.append(" ");
        Iterator itr = value.keySet().iterator();
        while (itr.hasNext()) {
            String key = itr.next().toString();
            Object o = value.get(key);
            stringBuilder.append(key);
            stringBuilder.append(" ");
            stringBuilder.append("=");
            stringBuilder.append(" ");
            stringBuilder.append("'");
            stringBuilder.append(o);
            stringBuilder.append("'");
            stringBuilder.append(" ,");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator whereClause(String req, Object o) {
        stringBuilder.append("WHERE");
        stringBuilder.append(" ");
        stringBuilder.append(req);
        stringBuilder.append(" ");
        stringBuilder.append("=");
        stringBuilder.append(" ");
        stringBuilder.append("'");
        stringBuilder.append(o);
        stringBuilder.append("'");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator whereClauseGraterThen(String req, Object o) {
        stringBuilder.append("WHERE");
        stringBuilder.append(" ");
        stringBuilder.append(req);
        stringBuilder.append(" ");
        stringBuilder.append(">");
        stringBuilder.append(" ");
        stringBuilder.append("'");
        stringBuilder.append(o);
        stringBuilder.append("'");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator whereClauseGraterThenEqualTo(String req, Object o) {
        stringBuilder.append("WHERE");
        stringBuilder.append(" ");
        stringBuilder.append(req);
        stringBuilder.append(" ");
        stringBuilder.append(">=");
        stringBuilder.append(" ");
        stringBuilder.append("'");
        stringBuilder.append(o);
        stringBuilder.append("'");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator collate(String req) {
        stringBuilder.append("COLLATE");
        stringBuilder.append(" ");
        stringBuilder.append(req);
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator whereClauseLike(String req, Object o) {
        stringBuilder.append("WHERE");
        stringBuilder.append(" ");
        stringBuilder.append(req);
        stringBuilder.append(" ");
        stringBuilder.append("LIKE");
        stringBuilder.append(" ");
        stringBuilder.append("'%");
        stringBuilder.append(o);
        stringBuilder.append("%'");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator union() {
        stringBuilder.append(" ");
        stringBuilder.append("UNION");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator unionAll() {
        stringBuilder.append(" ");
        stringBuilder.append("UNION ALL");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator whereClauseLike(HashMap<String, Object> value) {
        stringBuilder.append("WHERE");
        stringBuilder.append(" ");
        Iterator itr = value.keySet().iterator();
        while (itr.hasNext()) {
            String key = itr.next().toString();
            Object o = value.get(key);
            stringBuilder.append(key);
            stringBuilder.append(" ");
            stringBuilder.append("LIKE");
            stringBuilder.append(" ");
            stringBuilder.append("'%");
            stringBuilder.append(o);
            stringBuilder.append("%'");
            stringBuilder.append(" ");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator whereClauseMultipleLike(Object o, String... strings) {
        stringBuilder.append("WHERE");
        stringBuilder.append(" ");
        String s = TextUtils.join(",", strings);
        s = s.replace(",", " || ' ' || ");
        stringBuilder.append(s);
        stringBuilder.append(" ");
        stringBuilder.append("LIKE");
        stringBuilder.append(" ");
        stringBuilder.append("'%");
        stringBuilder.append(o);
        stringBuilder.append("%'");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator whereClauseNotNull(String req) {
        stringBuilder.append("WHERE");
        stringBuilder.append(" ");
        stringBuilder.append(req);
        stringBuilder.append(" ");
        stringBuilder.append("IS");
        stringBuilder.append(" ");
        stringBuilder.append("NOT");
        stringBuilder.append(" ");
        stringBuilder.append("NULL");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator whereClauseNotEqual(String req, Object o) {
        stringBuilder.append("WHERE");
        stringBuilder.append(" ");
        stringBuilder.append(req);
        stringBuilder.append(" ");
        stringBuilder.append("!=");
        stringBuilder.append(" ");
        stringBuilder.append("'");
        stringBuilder.append(o);
        stringBuilder.append("'");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator clause(HashMap<String, Object> value) {
        Iterator itr = value.keySet().iterator();
        while (itr.hasNext()) {
            String key = itr.next().toString();
            Object o = value.get(key);
            stringBuilder.append(key);
            stringBuilder.append(" ");
            stringBuilder.append("=");
            stringBuilder.append(" ");
            stringBuilder.append("'");
            stringBuilder.append(o);
            stringBuilder.append("'");
            stringBuilder.append(" ,");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator clauseNotEqual(HashMap<String, Object> value) {
        Iterator itr = value.keySet().iterator();
        while (itr.hasNext()) {
            String key = itr.next().toString();
            Object o = value.get(key);
            stringBuilder.append(key);
            stringBuilder.append(" ");
            stringBuilder.append("!=");
            stringBuilder.append(" ");
            stringBuilder.append("'");
            stringBuilder.append(o);
            stringBuilder.append("'");
            stringBuilder.append(" ,");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator clause(String req, Object o) {
        stringBuilder.append(req);
        stringBuilder.append(" ");
        stringBuilder.append("=");
        stringBuilder.append(" ");
        stringBuilder.append("'");
        stringBuilder.append(o);
        stringBuilder.append("'");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator clauseWithOutQuotes(String req, Object o) {
        stringBuilder.append(req);
        stringBuilder.append(" ");
        stringBuilder.append("=");
        stringBuilder.append(" ");
        stringBuilder.append(o);
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator graterThen(String req, Object o) {
        stringBuilder.append(req);
        stringBuilder.append(" ");
        stringBuilder.append(">");
        stringBuilder.append(" ");
        stringBuilder.append("'");
        stringBuilder.append(o);
        stringBuilder.append("'");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator WhereGraterThen(String req, Object o) {
        stringBuilder.append("WHERE");
        stringBuilder.append(" ");
        stringBuilder.append(req);
        stringBuilder.append(" ");
        stringBuilder.append(">");
        stringBuilder.append(" ");
        stringBuilder.append("'");
        stringBuilder.append(o);
        stringBuilder.append("'");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator whereGraterThen(String req, Object o) {
        stringBuilder.append("WHERE");
        stringBuilder.append(" ");
        stringBuilder.append(req);
        stringBuilder.append(" ");
        stringBuilder.append(">");
        stringBuilder.append(" ");
        stringBuilder.append("'");
        stringBuilder.append(o);
        stringBuilder.append("'");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator smallerThen(String req, Object o) {
        stringBuilder.append(req);
        stringBuilder.append(" ");
        stringBuilder.append("<");
        stringBuilder.append(" ");
        stringBuilder.append("'");
        stringBuilder.append(o);
        stringBuilder.append("'");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator clauseNotEqual(String req, Object o) {
        stringBuilder.append(req);
        stringBuilder.append(" ");
        stringBuilder.append("!=");
        stringBuilder.append(" ");
        stringBuilder.append("'");
        stringBuilder.append(o);
        stringBuilder.append("'");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator clauseNotNull(String req) {
        stringBuilder.append(req);
        stringBuilder.append(" ");
        stringBuilder.append("IS");
        stringBuilder.append(" ");
        stringBuilder.append("NOT");
        stringBuilder.append(" ");
        stringBuilder.append("NULL");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator clauseNull(String req) {
        stringBuilder.append(req);
        stringBuilder.append(" ");
        stringBuilder.append("IS");
        stringBuilder.append(" ");
        stringBuilder.append("NULL");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator IN(String value, String... req) {
        String s = TextUtils.join(",", req);
        stringBuilder.append(value);
        stringBuilder.append(" ");
        stringBuilder.append("IN");
        stringBuilder.append(" ");
        stringBuilder.append("(");
        stringBuilder.append(s);
        stringBuilder.append(")");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator whereIn(String value, String... req) {
        stringBuilder.append("WHERE");
        stringBuilder.append(" ");
        String s = TextUtils.join(",", req);
        stringBuilder.append(value);
        stringBuilder.append(" ");
        stringBuilder.append("IN");
        stringBuilder.append(" ");
        stringBuilder.append("(");
        stringBuilder.append(s);
        stringBuilder.append(")");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator notIN(String value, String... req) {
        String s = TextUtils.join(",", req);
        stringBuilder.append(value);
        stringBuilder.append(" ");
        stringBuilder.append("NOT IN");
        stringBuilder.append(" ");
        stringBuilder.append("(");
        stringBuilder.append(s);
        stringBuilder.append(")");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator notIN(String value, QueryGenerator queryGenerator) {
        stringBuilder.append(value);
        stringBuilder.append(" ");
        stringBuilder.append("NOT IN");
        stringBuilder.append(" ");
        stringBuilder.append("(");
        stringBuilder.append(queryGenerator.stringBuilder.toString());
        stringBuilder.append(")");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator notIN(String value, Integer... req) {
        String s = TextUtils.join(",", req);
        stringBuilder.append(value);
        stringBuilder.append(" ");
        stringBuilder.append("NOT IN");
        stringBuilder.append(" ");
        stringBuilder.append("(");
        stringBuilder.append(s);
        stringBuilder.append(")");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator like(String req, Object o) {
        stringBuilder.append(req);
        stringBuilder.append(" ");
        stringBuilder.append("LIKE");
        stringBuilder.append(" ");
        stringBuilder.append("'%");
        stringBuilder.append(o);
        stringBuilder.append("%'");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator multipleLike(Object o, String... strings) {
        String s = TextUtils.join(",", strings);
        s = s.replace(",", " || ' ' || ");
        stringBuilder.append(s);
        stringBuilder.append(" ");
        stringBuilder.append("LIKE");
        stringBuilder.append(" ");
        stringBuilder.append("'%");
        stringBuilder.append(o);
        stringBuilder.append("%'");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator multipleLikeBackWord(Object o, String... strings) {
        String s = TextUtils.join(",", strings);
        s = s.replace(",", " || ' ' || ");
        stringBuilder.append(s);
        stringBuilder.append(" ");
        stringBuilder.append("LIKE");
        stringBuilder.append(" ");
        stringBuilder.append("'%");
        stringBuilder.append(o);
        stringBuilder.append("'");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator multipleLikeForward(Object o, String... strings) {
        String s = TextUtils.join(",", strings);
        s = s.replace(",", " || ' ' || ");
        stringBuilder.append(s);
        stringBuilder.append(" ");
        stringBuilder.append("LIKE");
        stringBuilder.append(" ");
        stringBuilder.append("'");
        stringBuilder.append(o);
        stringBuilder.append("%'");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator multipleEqual(Object o, String... strings) {
        String s = TextUtils.join(",", strings);
        s = s.replace(",", " || ' ' || ");
        stringBuilder.append(s);
        stringBuilder.append(" ");
        stringBuilder.append("=");
        stringBuilder.append(" ");
        stringBuilder.append("'%");
        stringBuilder.append(o);
        stringBuilder.append("%'");
        stringBuilder.append(" ");
        return this;
    }


    public QueryGenerator like() {


        stringBuilder.append(" like");
        return this;
    }
/*
    public QueryGenerator whereClause(String value) {
        stringBuilder.append("WHERE");
        stringBuilder.append(" ");
        stringBuilder.append(value);
        stringBuilder.append(" ");
        return this;
    }
*/

    /*
     * @param orderBy
     * */
    public QueryGenerator orderBy(ORDERBY orderBy, String... value) {
        stringBuilder.append("ORDER BY ");
        stringBuilder.append(" ");
        stringBuilder.append(TextUtils.join(",", value));
        stringBuilder.append(" ");
        stringBuilder.append(orderBy.getKey());
        return this;
    }

    public QueryGenerator orderByNoCaseSensitive(ORDERBY orderBy, String... value) {
        stringBuilder.append("ORDER BY ");
        stringBuilder.append(" ");
        stringBuilder.append(TextUtils.join(",", value));
        stringBuilder.append(" ");
        stringBuilder.append("COLLATE NOCASE");
        stringBuilder.append(" ");
        stringBuilder.append(orderBy.getKey());
        return this;
    }

    public QueryGenerator orderByCustom() {
        stringBuilder.append("ORDER BY ");
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator limit(int value) {
        stringBuilder.append(" ");
        stringBuilder.append("LIMIT");
        stringBuilder.append(" ");
        stringBuilder.append(value);
        stringBuilder.append(" ");
        return this;
    }

    public QueryGenerator limit(int start, int end) {
        stringBuilder.append(" ");
        stringBuilder.append("LIMIT");
        stringBuilder.append(" ");
        stringBuilder.append(start);
        stringBuilder.append(",");
        stringBuilder.append(end);
        stringBuilder.append(" ");
        return this;
    }

    public SimpleSQLiteQuery build() {
        String query = stringBuilder.toString();
        return new SimpleSQLiteQuery(query);

    }


    public enum ORDERBY {
        ASC("ASC"),
        DESC("DESC");
        private String text;

        ORDERBY(String text) {
            this.text = text;
        }

        public String getKey() {
            return text;
        }

        @NonNull
        @Override
        public String toString() {
            return text;
        }
    }
}
