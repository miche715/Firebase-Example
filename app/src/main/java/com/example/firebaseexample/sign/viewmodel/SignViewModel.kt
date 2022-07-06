package com.example.firebaseexample.sign.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firebaseexample.sign.repository.SignRepository

class SignViewModel(private val signRepository: SignRepository = SignRepository()) : ViewModel()
{
    val signInResult: MutableLiveData<String?> = MutableLiveData()

    fun signIn(email: String, password: String)
    {
        signRepository.signInFirebase(email, password, signInResult)
    }
}

//class DiaryViewModel(val diaryRepository: DiaryRepository) : ViewModel()
//{
//    var _diaryData = MutableLiveData<MutableList<Diary>>()
//    var _countDiaryContents = MutableLiveData<HashMap<String, Int>>()
//
//    val diaryData get() = getData()
//    val countDiaryContents get() = _countDiaryContents
//
//    private fun getData(): MutableLiveData<MutableList<Diary>>
//    {
//        diaryRepository.getFirebaseData(diaryData, countDiaryContents)
//        return diaryData
//    }
//}
//
//class DiaryRepository(val databaseReference: DatabaseReference, )
//{
//    fun getFirebaseData(mutableLiveData: MutableLiveData<MutableList<Diary>>, count: MutableLiveData<HashMap<String, Int>>)
//    {
//        databaseReference.addValueEventListener(object : ValueEventListener()
//        {
//            override fun onDataChange(snapshot: DataSnapshot)
//            {
//                val diaryList = mutableListOf<Diary>()
//                val itemCount = HashMap<String, Int>()
//                for (snapshot in snapshot.children)
//                {
//                    val diary = snapshot.getValue(Diary::class.java)
//                    diaryList.add(diary!!)
//
//                    if (!diary.date.isNullOrEmpty())
//                    {
//                        val dateYMD = diary.date.substring(0, 10)
//                        if (!itemCount.containsKey(dateYMD))
//                        {
//                            itemCount[dateYMD] = 1
//                        }
//                        else
//                        {
//                            itemCount[dateYMD] = itemCount[dateYMD]!!.plus(1)
//                        }
//                    }
//
//                }
//                mutableLiveData.value = diaryList
//                count.value = itemCount
//                Log.d("Lee", "Data Changed ${count.value}")
//            }
//
//            override fun onCancelled(databaseError: DatabaseError)
//            {
//                // 디비를 가져오던중 에러 발생 시
//                Log.e("firebase", databaseError.toException().toString()) // 에러문 출력
//            }
//        })
//    }
//}