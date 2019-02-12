package com.vino.raven.kaathalaara.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vino.raven.kaathalaara.adapters.Adap_Contents;
import com.vino.raven.kaathalaara.model.ContentTitles;
import com.vino.raven.kaathalaara.R;

import java.util.ArrayList;
import java.util.List;


public class Contents extends Fragment {
    RecyclerView rv_Contents;

    ContentTitles contentTitles;
    List<ContentTitles> titlesList=new ArrayList<>();
    Adap_Contents adap_contents;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View contentsView= inflater.inflate(R.layout.fragment_contents, container, false);
        rv_Contents=contentsView.findViewById(R.id.rv_Contents);
        setContents();
        adap_contents=new Adap_Contents(titlesList);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        rv_Contents.setLayoutManager(layoutManager);
        rv_Contents.setAdapter(adap_contents);
        return contentsView;
    }

    private void setContents() {
        contentTitles=new ContentTitles("1",getResources().getString(R.string.title_content1),"\u0BACனிகள் \u0BA5ட்டுல\u0BA5 இன்த\u0BA5ாய். . .\n");
        titlesList.add(contentTitles);
        contentTitles=new ContentTitles("2"," அந்\u0BA1ப் தார்த\u0BAC \u0B8Bன்ண தாச க\u0BA6ி \n","\u0BACனிகள் \u0BA5ட்டுல\u0BA5 இன்த\u0BA5ாய். . .\n");
        titlesList.add(contentTitles);
        contentTitles=new ContentTitles("3",". சிக்கித் \u0BA1\u0BACிக்கிலநன் சிதன அ\u0BABகில","\u0BACனிகள் \u0BA5ட்டுல\u0BA5 இன்த\u0BA5ாய். . .\n");
        titlesList.add(contentTitles);
        contentTitles=new ContentTitles("4","\u0BACி\u0BABிகதப \u0BA5ட்டும் \u0BACிட்டு மசல","\u0BACனிகள் \u0BA5ட்டுல\u0BA5 இன்த\u0BA5ாய். . .\n");
        titlesList.add(contentTitles);
        contentTitles=new ContentTitles("5","உன் \u0BACாசம் \u0BA1ாக்கில\u0BA6 \u0BACாடிப் லதாகணும்\n","\u0BACனிகள் \u0BA5ட்டுல\u0BA5 இன்த\u0BA5ாய். . .\n");
        titlesList.add(contentTitles);
    }

}
