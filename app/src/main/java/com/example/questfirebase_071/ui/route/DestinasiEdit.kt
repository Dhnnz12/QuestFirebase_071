package com.example.questfirebase_071.ui.route

import com.example.questfirebase_071.R

object DestinasiEdit : DestinasiNavigasi{
    override val route = "item_edit"
    override val titleRes = R.string.edit_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}