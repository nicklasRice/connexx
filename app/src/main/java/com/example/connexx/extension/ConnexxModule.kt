package com.example.connexx.extension

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ServiceScoped
import io.hammerhead.karooext.KarooSystemService

/**
 * Hilt module for Connexx dependencies
 */
@Module
@InstallIn
class ConnexxModule {
    @Provides
    @ServiceScoped
    fun provideKarooSystemService(@ApplicationContext context: Context) : KarooSystemService =
        KarooSystemService(context)
}