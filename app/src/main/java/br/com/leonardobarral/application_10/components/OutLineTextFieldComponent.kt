package br.com.leonardobarral.application_10.components

import android.util.Log
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.leonardobarral.application_10.models.Cep
import br.com.leonardobarral.application_10.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun OutLineTextFieldComponent(
    value:String,
    onValueChage: (String) -> Unit,
    label:String,
    placeholder: String,
    modifier: Modifier,
    icone: ImageVector,
    onListCepChange:(List<Cep>) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = {onValueChage(it)},
        label = {
            Text(text = label)
        },
        placeholder={
            Text(text = placeholder)
        },
        modifier = modifier,
        trailingIcon = {
            IconButton(
                onClick = {

                    var call = RetrofitFactory().getCepService().getEnderecoByCep(
                        cep = value
                    )

                    call.enqueue(object : Callback<Cep> {
                        override fun onResponse(
                            call: Call<Cep>,
                            response: Response<Cep>
                        ) {
                            var cepList: MutableList<Cep> = mutableListOf()

                            cepList.add(response.body()!!)
//                            Log.i("FIAP","onResponse${response.body()}")
                            onListCepChange(cepList)
                        }
                        override fun onFailure(call: Call<Cep>, t: Throwable) {
                            Log.i("FIAP","onResponse${t.message}")
                        }
                    })
                }
            ) {
                Icon(imageVector = icone , contentDescription ="" )
            }
        }
    )
}