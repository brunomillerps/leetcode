package bmps.com.delivery.weather;

import java.util.List;

public record WeatherResponse(
        int page, int per_page, int total,
        int total_pages, List<Weather> data) {
}