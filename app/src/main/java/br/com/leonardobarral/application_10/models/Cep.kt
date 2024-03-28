package br.com.leonardobarral.application_10.models

import com.google.gson.annotations.SerializedName

data class Cep (
    val cep:String = "",
    @SerializedName("logradouro") val rua:String = "",
    @SerializedName("localidade") val cidade:String = "",
    val bairro:String = "",
    val uf:String = "",
)