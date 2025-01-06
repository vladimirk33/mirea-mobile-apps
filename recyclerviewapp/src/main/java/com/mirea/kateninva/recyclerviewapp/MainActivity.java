package com.mirea.kateninva.recyclerviewapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.content_view);
        List<HistoricEvent> historicEvents = getEventsList();
        recyclerView.setAdapter(new EventRecyclerAdapter(historicEvents));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private List<HistoricEvent> getEventsList() {
        List<HistoricEvent> historicEvents = new ArrayList<>();
        HistoricEvent revolution = new HistoricEvent("Революция 1917 года в России",
                "В 1917 году в России произошли две революции: Февральская и Октябрьская. Февральская привела к свержению монархии и установлению Временного правительства. Октябрьская революция, возглавленная большевиками под руководством Владимира Ленина, привела к установлению советской власти и началу социалистических преобразований.",
                "revolution");
        HistoricEvent stalingrad = new HistoricEvent("Сталинградская битва (1942–1943)",
                "Сражение между советскими и немецкими войсками за город Сталинград стало одним из ключевых эпизодов Второй мировой войны. Победа Красной армии в этой битве стала поворотным моментом в войне, остановив наступление Германии на Восточном фронте.",
                "stalingrad");
        HistoricEvent berlin = new HistoricEvent("Падение Берлинской стены (1989)",
                "Символ Холодной войны, разделявший Восточный и Западный Берлин, был разрушен в 1989 году. Это событие ознаменовало конец разделения Германии и начало процесса объединения страны.",
                "berlin");
        historicEvents.add(revolution);
        historicEvents.add(stalingrad);
        historicEvents.add(berlin);

        return historicEvents;
    }
}