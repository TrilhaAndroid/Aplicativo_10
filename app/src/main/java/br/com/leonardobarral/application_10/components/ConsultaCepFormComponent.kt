package br.com.leonardobarral.application_10.components


import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.leonardobarral.application_10.models.Cep
import br.com.leonardobarral.application_10.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Composable
fun ConsultaCepFormComponent(
    cep: String,
    updateCep: (String) -> Unit,
    uf: String,
    updateUf: (String) -> Unit,
    cidade: String,
    updateCidade: (String) -> Unit,
    rua: String,
    updateRua: (String) -> Unit,

    updateListCepFunc: (List<Cep>) -> Unit

) {
    Card {
        Column(
            modifier = Modifier
                .padding(15.dp)
        ) {

            Text(
                text = "CONSULTA CEP",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 5.dp)
            )

            Text(
                text = "Encontre o seu endereço",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            OutLineTextFieldComponent(
                value = cep,
                onValueChage = { updateCep(it) },
                label = "Qual o CEP procurado?",
                placeholder = "00000-000",
                modifier = Modifier
                    .fillMaxWidth(),
                icone = Icons.Default.Search,
                onListCepChange = { updateListCepFunc(it) }
            )

            Text(
                text = "Não sabe o CEP?",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 5.dp, top = 15.dp)
            )
            Row {
                TextFieldComponent(
                    value = uf,
                    onValueChage = { updateUf(it) },
                    label = "UF?",
                    placeholder = "SP",
                    modifier = Modifier
                        .fillMaxWidth(0.3f)
                        .border(1.dp, Color.DarkGray)
                )
                Spacer(modifier = Modifier.width(5.dp))
                TextFieldComponent(
                    value = cidade,
                    onValueChage = { updateCidade(it) },
                    label = "Qual a cidade?",
                    placeholder = "São Paulo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color.DarkGray)
                )

            }


            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextFieldComponent(
                    value = rua,
                    onValueChage = { updateRua(it) },
                    label = "Nome da rua?",
                    placeholder = "rua dois de abril",
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .border(1.dp, Color.DarkGray)
                )
                IconButton(
                    onClick = {

                        val call = RetrofitFactory().getCepService().getEnderecoByUfCidade(
                            uf = uf,
                            cidade = cidade,
                            rua = rua
                        )

                        call.enqueue(object : Callback<List<Cep>> {
                            override fun onResponse(
                                call: Call<List<Cep>>,
                                response: Response<List<Cep>>
                            ) {
//                                Log.i("FIAP","onResponse${response.body()}")
                                updateListCepFunc(response.body()!!)
                            }

                            override fun onFailure(call: Call<List<Cep>>, t: Throwable) {
                                Log.i("FIAP", "onResponse${t.message}")
                            }

                        })


//                        updateListCepFunc(it)
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = ""
                    )
                }
            }

        }
    }
}