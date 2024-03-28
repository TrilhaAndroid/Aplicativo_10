package br.com.leonardobarral.application_10.service

import br.com.leonardobarral.application_10.models.Cep
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CepService {
    //Base url
    //https://viacep.com.br/ws/RS/

    //https://viacep.com.br/ws/RS/Porto Alegre/Domingos/json/

    @GET("{cep}/json/")
    fun getEnderecoByCep(@Path("cep") cep:String): Call<Cep>

    @GET("{uf}/{cidade}/{rua}/json/")
    fun getEnderecoByUfCidade(
        @Path("uf") uf: String,
        @Path("cidade") cidade: String,
        @Path("rua") rua: String
    ):Call<List<Cep>>

}