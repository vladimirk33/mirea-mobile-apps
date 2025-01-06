package com.mirea.kateninva.drinkproject.viewModels;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.mirea.kateninva.drinkproject.MainActivity;
import com.mirea.kateninva.data.firebase.AuthController;
import com.mirea.kateninva.data.firebase.FirebaseAuthController;
import com.mirea.kateninva.data.repository.AuthRepositoryImpl;
import com.mirea.kateninva.domain.AuthorizationCallback;
import com.mirea.kateninva.domain.usecases.auth.HasUserLoggedUseCase;
import com.mirea.kateninva.domain.usecases.auth.SignInUseCase;
import com.mirea.kateninva.domain.usecases.auth.SignUpUseCase;

public class AuthActivityViewModel extends ViewModel {

    private final Context context;

    private SignInUseCase signInUseCase;
    private SignUpUseCase signUpUseCase;
    private HasUserLoggedUseCase hasUserLoggedUseCase;

    public AuthActivityViewModel(Context context) {
        this.context = context;

        setupUseCases();
        checkAuthorized();
    }

    private void setupUseCases() {
        AuthController authController = new FirebaseAuthController();
        AuthRepositoryImpl authRepository = new AuthRepositoryImpl(authController);

        signInUseCase = new SignInUseCase(authRepository);
        signUpUseCase = new SignUpUseCase(authRepository);
        hasUserLoggedUseCase = new HasUserLoggedUseCase(authRepository);
    }

    private void checkAuthorized() {
        if (hasUserLoggedUseCase.execute()) {
            changeActivity();
        }
    }

    public void register(String nickname, String email, String password) {
        signUpUseCase.execute(nickname, email, password, new AuthorizationCallback() {
            @Override
            public void onSuccess() {
                changeActivity();
            }

            @Override
            public void onFailure() {
                Toast.makeText(context, "Что-то пошло не так", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void login(String email, String password) {
        signInUseCase.execute(email, password, new AuthorizationCallback() {
            @Override
            public void onSuccess() {
                changeActivity();
            }

            @Override
            public void onFailure() {
                Toast.makeText(context, "Что-то пошло не так", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void changeActivity() {
        context.startActivity(new Intent(context, MainActivity.class));
    }

}
