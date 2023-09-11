package com.example.springbootretry.adapter.out.mysql.model.mapper

import com.example.springbootretry.adapter.out.mysql.model.BookMySqlModel
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class BookMySqlMapper: RowMapper<BookMySqlModel> {
    override fun mapRow(rs: ResultSet, rowNum: Int): BookMySqlModel {
        return BookMySqlModel(
            rs.getLong("ID"),
            rs.getString("TITLE"),
            rs.getString("AUTHOR")
        )
    }
}