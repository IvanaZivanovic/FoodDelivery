package com.comtrade.domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

public interface BaseDomain extends Serializable{

	String getTableName();

	String getColumnNames();

	String getValues();

	void setValuesInsert(PreparedStatement preparedStatement);

	Set<BaseDomain> selectAll(ResultSet resultSet);

	String setUpdateValues();

	String getId();

	void setUpdate(PreparedStatement preparedStatement);

	void setDelete(PreparedStatement preparedStatement);

	
	

}
