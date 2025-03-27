package com.ramiro.castrejon.book.data.database

import androidx.room.RoomDatabaseConstructor

//ROOM COMPILER WILL GENERATE THE ACTUAL DECLARATIONS FOR EACH PLATFORM
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object BookDatabaseConstructor :RoomDatabaseConstructor<FavoriteBookDatabase> {
    override fun initialize(): FavoriteBookDatabase
}