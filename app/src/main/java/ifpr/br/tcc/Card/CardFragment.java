package ifpr.br.tcc.Card;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import ifpr.br.tcc.Agua;
import ifpr.br.tcc.Cachorro;
import ifpr.br.tcc.Comida;
import ifpr.br.tcc.MainActivity;
import ifpr.br.tcc.R;
import ifpr.br.tcc.Vacina;

public class CardFragment extends Fragment {

    private CardView cardView;

    public static Fragment getInstance(int position) {
        CardFragment f = new CardFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        f.setArguments(args);

        return f;
    }

    @SuppressLint("DefaultLocale")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_viewpager, container, false);

        cardView = view.findViewById(R.id.cardView);
        cardView.setMaxCardElevation(cardView.getCardElevation() * CardAdapter.MAX_ELEVATION_FACTOR);

        ImageView icone = view.findViewById(R.id.icone);
        TextView title = view.findViewById(R.id.title);
        TextView text = view.findViewById(R.id.text);
        Button button = view.findViewById(R.id.button);

        if (getArguments().getInt("position" ) == 0 ) {
            title.setText(String.format("Dog"));
            text.setText (String.format("Informações sobre seu cão"));
            icone.setImageResource(R.drawable.paw);
            button.setText(String.format("Cachorro"));
        }
        else if (getArguments().getInt("position" ) == 1 ) {
            title.setText(String.format("Vacinas"));
            text.setText (String.format("Quais vacinas ele já tomou ou precisa tomar?"));
            icone.setImageResource(R.drawable.vacina);
            button.setText(String.format("Vacina"));
        }
        else if (getArguments().getInt("position" ) == 2 ) {
            title.setText(String.format("Água"));
            text.setText (String.format("Quanto de Água se deve dar?"));
            icone.setImageResource(R.drawable.agua);
            button.setText(String.format("Água"));
        }
        else if (getArguments().getInt("position" ) == 3 ) {
            title.setText(String.format("Comida"));
            text.setText (String.format("Quanto de comida dar para seu cão?"));
            icone.setImageResource(R.drawable.comida);
            button.setText(String.format("Comida"));
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getArguments().getInt("position" ) == 0 ) {
                    Intent intentDog = new Intent(getContext(), Cachorro.class);
                    startActivity(intentDog);

                }
                else if (getArguments().getInt("position" ) == 1) {
                    Intent intentVacina = new Intent(getContext(), Vacina.class);
                    startActivity(intentVacina);
                }
                else if (getArguments().getInt("position" ) == 2 ) {
                    Intent intentAgua = new Intent(getContext(), Agua.class);
                    startActivity(intentAgua);
                }
                else if (getArguments().getInt("position" ) == 3) {
                    Intent intentComida = new Intent(getContext(), Comida.class);
                    startActivity(intentComida);

                }

            }
        });

        return view;
    }

    public CardView getCardView() {
        return cardView;
    }
}