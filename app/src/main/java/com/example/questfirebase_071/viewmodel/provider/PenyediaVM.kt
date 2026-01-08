package com.example.questfirebase_071.viewmodel.provider

import androidx.lifecycle.viewmodel.CreationExtras
import com.example.questfirebase_071.repository.AplikasiDataSiswa
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.questfirebase_071.viewmodel.DetailViewModel
import com.example.questfirebase_071.viewmodel.EditViewModel
import com.example.questfirebase_071.viewmodel.EntryVM
import com.example.questfirebase_071.viewmodel.HomeVM

fun CreationExtras.aplikasiDataSiswa(): AplikasiDataSiswa = (
        this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiDataSiswa
        )

object PenyediaVM {
    val Factory = viewModelFactory {
        initializer { HomeVM(aplikasiDataSiswa().container.repositorySiswa) }
        initializer { EntryVM(aplikasiDataSiswa().container.repositorySiswa) }
        initializer {
            DetailViewModel(
                this.createSavedStateHandle(),
                aplikasiDataSiswa().container.repositorySiswa
            )
        }
        initializer {
            EditViewModel(
                this.createSavedStateHandle(),
                aplikasiDataSiswa().container.repositorySiswa
            )
        }
    }
}