package it.capgemini.archetype.dao.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.querydsl.core.types.dsl.BooleanExpression;

import it.capgemini.archetype.dao.DAO;

public abstract class AbstractDAO implements DAO {
	public final int MAX_LIMIT = 5000;

	@Override
	public String addPercent(String text) {
		StringBuilder sb = new StringBuilder(text);

		sb.insert(0, "%");
		sb.append("%");

		return sb.toString();
	}

	@Override
	public BooleanExpression and(List<BooleanExpression> expressions) {
		if (CollectionUtils.isEmpty(expressions))
			return null;

		BooleanExpression andExpression = null;
		for (BooleanExpression expression : expressions) {
			andExpression = andExpression == null ? expression : andExpression.and(expression);
		}
		return andExpression;
	}

}
