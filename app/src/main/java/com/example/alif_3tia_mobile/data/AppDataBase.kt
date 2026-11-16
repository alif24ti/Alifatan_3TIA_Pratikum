package com.example.alif_3tia_mobile.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.alif_3tia_mobile.data.Entity.NoteEntity
import com.example.alif_3tia_mobile.data.dao.NoteDao

@Database(
    entities = [NoteEntity::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Tahap 09: migrasi versi 1 -> 2 (menambah kolom isPinned tanpa menghapus data)
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    "ALTER TABLE notes " +
                            "ADD COLUMN isPinned INTEGER NOT NULL DEFAULT 0"
                )
            }
        }

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .addMigrations(MIGRATION_1_2)
                    // Opsi reset khusus data latihan (Tahap 09, langkah 17).
                    // Jangan aktifkan bersama migrasi di atas untuk data penting.
                    // .fallbackToDestructiveMigration()
                    .build().also { INSTANCE = it }
            }
    }
}
