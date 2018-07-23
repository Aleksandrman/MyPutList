package org.getDistance;

import java.io.*;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

import org.json.*;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

public class GetDistAndTime extends AbstractSample{
	String dist;
	String time;
	
	/**
	 * @return the dist
	 */
	public String getDist() {
		return dist;
	}

	/**
	 * @param dist the dist to set
	 */
	public void setDist(String dist) {
		this.dist = dist;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	public String get_address(String address_a, String address_b) throws IOException, JSONException {
//		String  adress_a = "улица Красноярская, 24";
//		String  adress_b = "улица Киевская, 9а";
		final String baseUrl = "http://maps.googleapis.com/maps/api/directions/json";// путь к Geocoding API по
		// HTTP
		final Map<String, String> params = Maps.newHashMap();
		params.put("sensor", "false");// указывает, исходит ли запрос на геокодирование от устройства с датчиком
		params.put("language", "ru");// язык данные на котором мы хотим получить
		params.put("mode", "driving");// способ перемещения, может быть driving, walking, bicycling
		params.put("origin", address_a);// адрес или текстовое значение широты и
		params.put("destination",address_b);// адрес или текстовое значение широты и
		// долготы
		// долготы конечного пункта маршрута
		final String url = baseUrl + '?' + encodeParams(params);// генерируем путь с параметрами
//		System.out.println(url); // Можем проверить что вернет этот путь в браузере
		final JSONObject response = JsonReader.read(url);// делаем запрос к вебсервису и получаем от него ответ
		// как правило наиболее подходящий ответ первый и данные о координатах можно получить по пути
		// //results[0]/geometry/location/lng и //results[0]/geometry/location/lat
		JSONObject location = response.getJSONArray("routes").getJSONObject(0);
		location = location.getJSONArray("legs").getJSONObject(0);
		final String distance = location.getJSONObject("distance").getString("text");
		final String duration = location.getJSONObject("duration").getString("text");
//		System.out.println(distance + "\n" + duration);
		setDist(distance);
		setTime(duration);
		return distance + "  " + duration;
	}
}
