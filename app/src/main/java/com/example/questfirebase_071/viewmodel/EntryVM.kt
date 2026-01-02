package com.example.questfirebase_071.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.questfirebase_071.model.DetailSiswa
import com.example.questfirebase_071.model.UIStateSiswa // Pastikan ini terimport
import com.example.questfirebase_071.model.toDataSiswa
import com.example.questfirebase_071.repository.RepositorySiswa

class EntryVM(private val repositorySiswa: RepositorySiswa): ViewModel(){

    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    // Perbaikan: detailSiswa menggunakan 'd' kecil sesuai definisi di model
    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean
    {
        return with(uiState){
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    fun updateUIState(detailSiswa: DetailSiswa){
        uiStateSiswa =
            UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
    }

    suspend fun addSiswa(){
        if (validasiInput()){
            // Perbaikan: detailSiswa (d kecil)
            repositorySiswa.postDataSiswa(uiStateSiswa.detailSiswa.toDataSiswa())
        }
    }
}
