package br.com.leonardobarral.application_10.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.leonardobarral.application_10.models.Cep

@Composable
fun ListCardCepComponent(listCep: List<Cep>) {
    LazyColumn(
        userScrollEnabled = true
    ){
        items(listCep){
            CardCepComponent(cep = it)
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}