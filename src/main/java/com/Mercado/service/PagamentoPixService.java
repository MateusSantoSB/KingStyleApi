package com.Mercado.service;

import static java.lang.Integer.toHexString;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.Mercado.model.PagamentoDestinoPix;


@Service
public class PagamentoPixService {
	private   String pfi = "01";

    public  String crc_cod = "6304";

    private  String pais_cod = "BR";

    private  String moeda_cod = "986";

    private  String arranjo_pag = "BR.GOV.BCB.PIX";

    private  String mcc = "0000";

    private  String cod_valor = "54";

    private  String id_transacao = "***";

    private  PagamentoDestinoPix dadosPix;
 
    private String code = "";

    public PagamentoPixService() {
    	
    }
  
    
    public String iniciar(PagamentoDestinoPix dados) {
    	this.dadosPix=dados;
    	return this.gerarCodigo();
    }
    
    
	
	private JSONObject objetoJson() {
	        final var jsonTemplate =
	            """
	            {
	                '00': '%s',
	                '26': {
	                    '00': '%s',
	                    '01': '%s',
	                    '02': '%s'
	                },
	                '52': '%s',
	                '53': '%s',
	                '%s': '%s',
	                '58': '%s',
	                '59': '%s',
	                '60': '%s',
	                '62': {
	                    '05': '%s'
	                }
	            }
	            """;
	        
	         var json =
	            jsonTemplate
	                .formatted(
	                        pfi, arranjo_pag, dadosPix.getChaveDestinatario(), dadosPix.getDescricao(),
	                        mcc, moeda_cod, cod_valor, dadosPix.getValor().toString(), pais_cod,
	                        dadosPix.getNomeDestinatario(), dadosPix.getCidadeRemetente(), id_transacao);
	        return new JSONObject(json);
	    }
	    public String gerarCodigo() {
	        String partialCode = gerarString(objetoJson()) + crc_cod;
	        String checksum = gerarCRC(partialCode);
	        return juntarCodigo(partialCode + checksum);
	    }
	    
	    private String juntarCodigo( String code) {
	        this.code = code;
	        return code;
	    }
	   
	    private String gerarCRC( String partialCode){
	        int crc = 0xFFFF;
	        var byteArray = partialCode.getBytes();
	        for (final byte b : byteArray) {
	            crc ^= b << 8;
	            for (int i = 0; i < 8; i++) {
	                if ((crc & 0x8000) == 0)
	                    crc = crc << 1;
	                else crc = (crc << 1) ^ 0x1021;
	            }
	        }

	        int decimal = crc & 0xFFFF; 
	        return zeroEspac(toHexString(decimal), 4).toUpperCase();
	    }
	    private String gerarString(JSONObject jsonObj) {
	        StringBuilder stringBuilder = new StringBuilder();
	        
	        jsonObj.keySet().stream().sorted().forEach(key -> {
	             Object val = jsonObj.get(key);
	             
	             String str = encodeValue(key, val);
	            stringBuilder.append(zeroEsq(key)).append(calcString(str)).append(str);
	        });

	        return stringBuilder.toString();
	    }
	    
	    private String encodeValue( String key,  Object val) {
	        if(val instanceof JSONObject jsonObjValue) {
	            return gerarString(jsonObjValue);
	        }
	        	return val.toString();
	    }

	    static String calcString(String value) {
	        String len = String.valueOf(value.length());
	        return zeroEsq(len);
	    }
	    
	    private static String zeroEsq(String code) {
	        return zeroEspac(code, 2);
	    }
	    
	    private static String zeroEspac(String code, int len) {
	        String format = "%1$" + len + "s";
	        return format.formatted(code).replace(' ', '0');
	    }
	
	
	
}
