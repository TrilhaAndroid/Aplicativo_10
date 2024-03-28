package br.com.leonardobarral.application_10.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CepModel:ViewModel() {
    private val _cep= MutableLiveData<String>()
    val cep:LiveData<String> = _cep

    fun updateCep(novoValor:String){
        _cep.value = novoValor
    }


    private val _uf= MutableLiveData<String>()
    val uf:LiveData<String> = _uf

    fun updateUf(novoValor:String){
        _uf.value = novoValor
    }


    private val _cidade= MutableLiveData<String>()
    val cidade:LiveData<String> = _cidade

    fun updateCidade(novoValor:String){
        _cidade.value = novoValor
    }


    private val _rua= MutableLiveData<String>()
    val rua:LiveData<String> = _rua

    fun updateRua(novoValor:String){
        _rua.value = novoValor
    }


    private val _listCep = MutableLiveData<List<Cep>>()
    val listCep:LiveData<List<Cep>> = _listCep

    fun updateListCep(novoValor:List<Cep>){
        _listCep.value = novoValor
    }
}