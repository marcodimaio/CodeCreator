package it.capgemini.archetype.dao;

import java.util.List;

import com.querydsl.core.types.dsl.BooleanExpression;

public interface DAO {
	public String addPercent(String text);

	public BooleanExpression and(List<BooleanExpression> expressions);

}
