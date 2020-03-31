package br.com.preventsenior.util;

import br.com.preventsenior.framework.kinesis.dto.KinesisRecord;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Classe utilitaria que converte um objeto em json e vice versa
 * @author Michel Mendes
 * @since 23/03/2020
 */
public class JsonParser<obj> {

    /**
     * Converte um json em um objeto
     * @param st String contendo o json
     * @param clazz classe que o json sera convertido
     * @return objeto convertido
     * @throws IOException
     */
    public obj convertJsonToObj(String st, Class<obj> clazz) throws IOException {
        if (st == null || st.isEmpty() || clazz == null) return null;
        ObjectMapper mapper = new ObjectMapper();
        obj obj = (obj) mapper.readValue(st, clazz);
        return obj;
    }

    /**
     * Converte um json em um objeto do tipo KinesisRecord, e dentro do campo 'data' o objeto de resposta
     * @param st String contendo o json
     * @param clazz classe que o campo 'data' do json sera convertido
     * @return objeto KinesisRecord
     * @throws IOException
     */
    public obj convertJsonToKinesisRecord(String st, Class clazz) throws IOException {
        if (st == null || st.isEmpty()) return null;

        ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().constructParametrizedType(KinesisRecord.class, KinesisRecord.class, clazz);
        obj obj = (obj) mapper.readValue(st, type);
        return obj;
    }

    /**
     * Converte um objeto em json
     * @param o objeto a ser convertido
     * @return String json
     * @throws JsonProcessingException
     */
    public String convertObjToJson(obj o) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String st = mapper.writeValueAsString(o);
        return  st;
    }

}
