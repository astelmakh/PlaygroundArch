package com.playground.featureshowcase.cache.db

object ShowCaseConstants {

    const val DATABASE_NAME = "db_showcase"
    const val TABLE_NAME = "showcase_content"

    const val QUERY_SHOWCASE_CONTENT = "SELECT * FROM" + " " + TABLE_NAME

    const val DELETE_ALL = "DELETE FROM" + " " + TABLE_NAME
}