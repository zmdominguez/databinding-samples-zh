package dev.zarah.databinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

// based on data from https://randomuser.me/api/
val PROFILES = listOf(
    Profile("Katie Harris", "Australia", "https://randomuser.me/api/portraits/women/51.jpg", 1),
    Profile("Isaac Hernandez", "Spain", "https://randomuser.me/api/portraits/men/97.jpg", 5),
    Profile("Clara Obrien", "United States", "https://randomuser.me/api/portraits/women/72.jpg", 0),
    Profile("Elias Manner", "Finland", "https://randomuser.me/api/portraits/men/39.jpg", 21)

)

class ProfileViewModel {
    private var currentProfile = 0
    val profile: LiveData<Profile> = MutableLiveData(PROFILES[currentProfile])

    fun nextProfile() {
        currentProfile = (currentProfile + 1) % PROFILES.size
        (profile as MutableLiveData).value = PROFILES[currentProfile]
    }
}

data class Profile(val name: String, val location: String, val avatarUrl: String, val orderCount: Int)