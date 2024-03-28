package br.com.leonardobarral.application_10.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.leonardobarral.application_10.components.ConsultaCepFormComponent
import br.com.leonardobarral.application_10.components.ListCardCepComponent
import br.com.leonardobarral.application_10.models.CepModel

@Composable
fun ConsultaCepScreen(cepModel: CepModel) {

    val cep by cepModel.cep.observeAsState(initial = "")
    val uf by cepModel.uf.observeAsState(initial = "")
    val cidade by cepModel.cidade.observeAsState(initial = "")
    val rua by cepModel.rua.observeAsState(initial = "")
    val listCep by cepModel.listCep.observeAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .padding(15.dp)
    ) {
        ConsultaCepFormComponent(
            cep = cep,
            updateCep = { cepModel.updateCep(it) },

            rua = rua,
            updateRua = { cepModel.updateRua(it) },

            cidade = cidade,
            updateCidade = { cepModel.updateCidade(it) },

            uf = uf,
            updateUf = { cepModel.updateUf(it) },

            updateListCepFunc = { cepModel.updateListCep(it)}

        )
        Spacer(modifier = Modifier.height(10.dp))
        ListCardCepComponent(listCep)
    }

}