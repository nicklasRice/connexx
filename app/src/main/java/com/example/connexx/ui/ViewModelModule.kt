package com.example.connexx.ui

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import io.hammerhead.karooext.KarooSystemService

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {
    @Provides
    fun provideKarooSystemService(@ApplicationContext context: Context) : KarooSystemService =
        KarooSystemService(context)
}