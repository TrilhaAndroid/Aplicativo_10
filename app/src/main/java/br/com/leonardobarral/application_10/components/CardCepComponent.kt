package br.com.leonardobarral.application_10.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.leonardobarral.application_10.models.Cep

@Composable
fun CardCepComponent(cep: Cep) {
    Card (
        modifier = Modifier.fillMaxWidth()
    ){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ){
            Row {
                Text(text = "CEP:")
                Spacer(modifier = Modifier.width(3.dp))
                Text(text = cep.cep)
            }
            Spacer(modifier = Modifier.height(3.dp))
            Row {
                Text(text = "Rua:")
                Spacer(modifier = Modifier.width(3.dp))
                Text(text = cep.rua)
            }
            Spacer(modifier = Modifier.height(3.dp))
            Row {
                Text(text = "Cidade:")
                Spacer(modifier = Modifier.width(3.dp))
                Text(text = cep.cidade)
            }
            Spacer(modifier = Modifier.height(3.dp))
            Row {
                Text(text = "Bairro:")
                Spacer(modifier = Modifier.width(3.dp))
                Text(text = cep.bairro)
            }
            Spacer(modifier = Modifier.height(3.dp))
            Row {
                Text(text = "UF:")
                Spacer(modifier = Modifier.width(3.dp))
                Text(text = cep.uf)
            }

        }
    }
}