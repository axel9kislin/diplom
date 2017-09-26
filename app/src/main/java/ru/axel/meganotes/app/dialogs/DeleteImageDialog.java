package ru.axel.meganotes.app.dialogs;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import ru.axel.meganotes.app.R;

public class DeleteImageDialog extends DialogFragment {

    private OnClickListenerDelete mOnItemClickListener;
    public static final String DIALOG_KEY = "dialogDeleteImage";

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mOnItemClickListener = (OnClickListenerDelete) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " должен реализовывать интерфейс OnClickListenerDelete");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View viewDialog = inflater.inflate(R.layout.fragment_dialog, container, false);
        ListView listView = (ListView) viewDialog.findViewById(R.id.list);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,
                new String[] {getString(R.string.item_del)});

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mOnItemClickListener.onDeleteImage(DeleteImageDialog.this, position);
            }
        });

        return viewDialog;
    }

    public interface OnClickListenerDelete {
        void onDeleteImage(DialogFragment dialog, int position);
    }
}
