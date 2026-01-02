package com.example.questfirebase_071.ui.theme.route

import com.example.questfirebase_071.R

object DestinasiDetail : DestinasiNavigasi{
    override val route = "detail_siswa"
    override val titleRes= R.string.detail_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}